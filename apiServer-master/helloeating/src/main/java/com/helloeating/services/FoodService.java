package com.helloeating.services;

import java.util.List;
import java.util.Map;

import com.helloeating.common.Const;

public interface FoodService {

	/**
	 * 상점 1개 정보
	 * @param map store_id 상점id
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> SelectStoreInfo (Map<String, Object> map) throws Exception;
	
	/**
	 * 상점 리뷰
	 * @param storeId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> SelectReview (Map<String, Object> map) throws Exception;
	
	/**
	 * 해당 상점 리뷰의 총 페이지 수
	 * @param storeId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> StoreMoreInfo (Map<String, Object> map) throws Exception;
	
	public List<String> SelectReviewImages (Map<String, Object> map) throws Exception;
	
	public int totalReviewPage (Map<String, Object> map) throws Exception;
	
	//---------------------------------------------마이픽
	/**
	 * 마이픽 메인이벤트
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> myPick (Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalMyPick (Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalMyLike (Map<String, Object> map) throws Exception;
	
	/**
	 * 마이픽을 찾아줍니다
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMyPick (Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMyLike (Map<String, Object> map) throws Exception;
	
	public Map<String, Object> insertMyPick (Map<String, Object> map) throws Exception;
	
	public Map<String, Object> deleteMyPick (Map<String, Object> map) throws Exception;
	
	public int checkDuplicateMyPick (Map<String, Object> map) throws Exception; 
	
	//---------------------- 마이 올림픽 리스트
	public Map<String, Object> myOlympicList (Map<String, Object> map) throws Exception;
	/**
	 * 올림픽 리스트 페이징용 토탈페이지
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalMyOlympicList (Map<String, Object> map) throws Exception;
	/**
	 * 마이 올림픽리스트 저장
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> insertMyOlympicList (Map<String, Object> map) throws Exception;
	/**
	 * 마이 올림픽리스트 삭제
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteMyOlympicList (Map<String, Object> map) throws Exception;
	
	/**
	 * 올림픽 리스트를 찾아줍니다
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMyOlympicList (Map<String, Object> map) throws Exception;
	
	//--------------------베스트 올림픽 리스트
	public Map<String, Object> bestOlympicList (Map<String, Object> map) throws Exception;
	
	/**
	 * 베스트 올림픽 리스트의 토탈 넘버
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalBestOlympicList (Map<String, Object> map) throws Exception;
	/**
	 * 베스트 올림픽 리스트를 찾아줍니다.
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectBestOlympicList (Map<String, Object> map) throws Exception;
	
	//---------------- 리뷰 리스트
	public Map<String, Object> reviewList (Map<String, Object> map) throws Exception;
	
	/**
	 * 베스트 올림픽 리스트의 토탈 넘버
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalReviewList (Map<String, Object> map) throws Exception;
	/**
	 * 베스트 올림픽 리스트를 찾아줍니다.
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectReviewList (Map<String, Object> map) throws Exception;
	
	//--------------- 리뷰 입력
	/**
	 * 리뷰를 입력합니다
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> insertReview (Map<String, Object> map) throws Exception;
	
	public String selectReviewId (Map<String, Object> map) throws Exception;
	
	public Map<String, Object> updateReview (Map<String, Object> map) throws Exception;
	
	public Map<String, Object> deleteReview (Map<String, Object> map) throws Exception;
	
	public int reviewValidation (Map <String, Object> map) throws Exception;
	
	/**
	 * 좋아요 관련
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> likeMainEvent (Map<String, Object> map) throws Exception;
	
	public void likeIncrease (Map <String, Object> map) throws Exception;
	
	public void likeDecrease (Map <String, Object> map) throws Exception;
	
	public int likeCount (Map <String, Object> map) throws Exception;
	
	
	/**
	 * 
	 * @param tblConst
	 * @return
	 * @throws Exception
	 */
	public String getSEQ (Const.TABLE tblConst) throws Exception;
}
