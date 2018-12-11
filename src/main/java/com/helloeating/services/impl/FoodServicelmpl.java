package com.helloeating.services.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helloeating.common.Const;
import com.helloeating.common.Const.TABLE;
import com.helloeating.mapper.FoodMapper;
import com.helloeating.services.FoodService;
import com.helloeating.util.MakeResult;
import com.helloeating.util.PagingTools;
import com.helloeating.util.Validation;

@Component
public class FoodServicelmpl implements FoodService{

	private static final Logger logger = LogManager.getLogger(FoodServicelmpl.class);
	PagingTools pgTool = new PagingTools();
	MakeResult makeResult = new MakeResult();
	
	@Autowired
	FoodMapper foodMapper;
	
	@Override
	public Map<String, Object> SelectStoreInfo(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		
		// TODO Validation 
		String pkeys[] = {"store_id"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("SelectStoreInfo Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E5000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		//S5000
		// TODO 비지니스 로직

		
		// TODO DB 처
		msg = StoreMoreInfo(map);
		msg.put("image_list", SelectReviewImages(map));
		msg.put("total_page", pgTool.calTotalPage(totalReviewPage(map), 5));
		// TODO return 값 만들기
		msg.put("review_list", SelectReview(map));
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> SelectReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
		//TODO 페이징 처리
		List<Map<String, Object>> resultList = foodMapper.SelectReview(map);
		return resultList;
	}

	@Override
	public int totalReviewPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalReviewPage(map);
	}
	
	@Override
	public Map<String, Object> StoreMoreInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.StoreMoreInfo(map);
	}

	@Override
	public List<String> SelectReviewImages(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
		return foodMapper.SelectReviewImages(map);
	}	
	
	

	/**
	 * ----------------------------------- 마이픽
	 */
	@Override //마이픽 메인이벤트
	public Map<String, Object> myPick(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"member_no", "pick_type", "page_num"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("myPick Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E5010, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		map.put("page_num", pgTool.pageConvert(map.get("page_num").toString()));
		
		String pickType= (String)map.get("pick_type");
		
		int totalPage = 0;
		List storeList = null;
		
		switch(Const.PICK_TYPE.getValue1(pickType)){
			case LIKE : 
				totalPage = totalMyLike(map);
				storeList = selectMyLike(map);
				break;
				
			case PICK : 
				totalPage = totalMyPick(map);
				storeList = selectMyPick(map);
				break;
			
			default:
				logger.info("here");
				//TODO : Exception throw
		}
		// TODO DB 처리
		msg.put("total_page", pgTool.calTotalPage(totalPage, 5));
		msg.put("store_list", storeList);
		
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}
	
	@Override
	public int totalMyPick(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalMyPick(map);
	}
	
	
	@Override
	public List<Map<String, Object>> selectMyPick(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.selectMyPick(map);
	}
	
	@Override
	public Map<String, Object> insertMyPick(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		
		// TODO Validation
		String pkeys[] = {"member_no", "pick_type"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("myPick Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
		
		
		//중복 체크
		if (checkDuplicateMyPick(map) != 0) {
			resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
			
		// TODO DB 처리
		foodMapper.insertMyPick(map);
		
		// TODO 리턴값 생성
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		logger.info(resultMap);
		
		return resultMap;
	}

	@Override
	public Map<String, Object> deleteMyPick(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		
		// TODO Validation
		String pkeys[] = {"member_no", "pick_type"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("myPick Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
			
		// TODO DB 처리
		foodMapper.deleteMyPick(map);
		
		// TODO 리턴값 생성
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		logger.info(resultMap);
		
		return resultMap;
	}
	

	@Override
	public int totalMyLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalMyLike(map);
	}

	@Override
	public List<Map<String, Object>> selectMyLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.selectMyLike(map);
	}	
	
	
	@Override
	public int checkDuplicateMyPick(Map<String, Object> map) throws Exception {
		
		int duplication = 0;
		duplication = foodMapper.checkDuplicateMyPick(map);
		return duplication;
	}
	
	/**
	 * ---------------- 마이 올림픽 리스트
	 */
	@Override //마이픽 메인이벤트
	public Map<String, Object> myOlympicList (Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"member_no", "page_num"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("myOlympicList Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E5020, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		map.put("page_num", pgTool.pageConvert(map.get("page_num").toString()));
		// TODO DB 처리
		msg.put("total_page", pgTool.calTotalPage(totalMyOlympicList(map), 5));
		msg.put("store_list", selectMyOlympicList(map));
		
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public int totalMyOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalMyOlympicList(map);
	}

	@Override
	public List<Map<String, Object>> selectMyOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.selectMyOlympicList(map);
	}
	
	/**
	 * --------------------- 베스트 올림픽 리스트
	 */
	@Override
	public Map<String, Object> bestOlympicList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"page_num"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("best OlympicList Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		map.put("page_num", pgTool.pageConvert(map.get("page_num").toString()));
		// TODO DB 처리
		msg.put("total_page", pgTool.calTotalPage(totalBestOlympicList(map), 5));
		msg.put("store_list", selectBestOlympicList(map));
		
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public int totalBestOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalBestOlympicList(map);
	}

	@Override
	public List<Map<String, Object>> selectBestOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.selectBestOlympicList(map);
	}

	@Override
	public Map<String, Object> insertMyOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMyOlympicList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public Map<String, Object> reviewList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"store_id", "page_num"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("reviewList Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
		map.put("page_num", pgTool.pageConvert(map.get("page_num").toString()));
		
		// TODO DB 처리
		msg.put("total_page", pgTool.calTotalPage(totalReviewList(map), 5));
		msg.put("review_list", selectReviewList(map));
		
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public int totalReviewList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.totalReviewList(map);
	}

	@Override
	public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.selectReviewList(map);
	}

	@Override
	public Map<String, Object> insertReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"store_id", "content", "eat_like", "member_no", "reg_dt"};
		//E5000
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("insert review Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
		// TODO DB 처리
		String reviewID = getSEQ(Const.TABLE.REVIEW);
		map.put("review_id", reviewID);
		msg.put("review_id", reviewID);
		logger.info("리뷰아이디 : " + reviewID);
		logger.info(map);
		foodMapper.insertReview(map);
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;

	}
	
	@Override
	public String selectReviewId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Map<String, Object> updateReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"review_id", "eat_like", "content", "member_no"};
		//E5060
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("update review Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}

		
		if (reviewValidation(map) <= 0) {
			logger.error("해당 유저가 쓴 글이 아님");
			resultMap = makeResult.resultMap(Const.EConst.E5060, msg);
			
			return resultMap;
		}
		
		// TODO DB 처리

		logger.info(map);
		foodMapper.updateReview(map);
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public Map<String, Object> deleteReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"review_id", "eat_like", "content", "member_no"};
		//E5060
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("update review Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
		if (reviewValidation(map) <= 0) {
			logger.error("해당 유저가 쓴 글이 아님");
			resultMap = makeResult.resultMap(Const.EConst.E5060, msg);
			
			return resultMap;
		}
		
		// TODO DB 처리
		
		foodMapper.deleteReview(map);
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public int reviewValidation(Map<String, Object> map) throws Exception {
		
		return foodMapper.reviewValidation(map);
	}
	
	//================================================================================ 좋아요 시작
	@Override
	public Map<String, Object> likeMainEvent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		// TODO Validation
		String pkeys[] = {"target_type", "target_id", "cancel_flag"};
		//E5060
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("update review Valication 통과못함");
			
			resultMap = makeResult.resultMap(Const.EConst.E10000, msg);
			//나중에 맵으로 리턴;
			return resultMap;
		}
		
		
		// TODO DB 처리
		
		foodMapper.deleteReview(map);
		
		// TODO 리턴값 생성
		logger.info(resultMap);
		resultMap = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return resultMap;
	}

	@Override
	public void likeIncrease(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void likeDecrease(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int likeCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//================================================================================ 좋아요 끝
	
	@Override
	public String getSEQ(TABLE tblConst) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tblName", tblConst.getTable());
		
		return foodMapper.getSEQ(map);
	}

}
