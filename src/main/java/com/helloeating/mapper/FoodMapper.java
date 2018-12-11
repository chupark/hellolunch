package com.helloeating.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.helloeating.common.Const.TABLE;

@Mapper
public interface FoodMapper {
	public List<Map<String, Object>> SelectReview(Map<String, Object> map) throws Exception;
	
	public int totalReviewPage(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> StoreMoreInfo (Map<String, Object> map) throws Exception;
	
	public List<String> SelectReviewImages (Map<String, Object> map) throws Exception;
	
	//--------------------------- 마이픽
	public int totalMyPick (Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> selectMyPick (Map<String, Object> map) throws Exception;
	
	public int totalMyLike(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> selectMyLike(Map<String, Object> map) throws Exception;
	
	public void insertMyPick (Map<String, Object> map) throws Exception;
	
	public void deleteMyPick (Map<String, Object> map) throws Exception;
	
		//-- 마이 픽 중복 체크
	public int checkDuplicateMyPick (Map<String, Object> map) throws Exception;
	
	//-------------- 마이 올림픽 리스트
	public int totalMyOlympicList (Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> selectMyOlympicList (Map<String, Object> map) throws Exception;
	
	public void insertMyOlympicList (Map<String, Object> map) throws Exception;
	
	public void deleteMyOlympicList (Map<String, Object> map) throws Exception;
	
	//------------------ 베스트 올림픽 리스트
	public int totalBestOlympicList (Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> selectBestOlympicList (Map<String, Object> map) throws Exception;
	
	//---------------리뷰 리스트
	public int totalReviewList (Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> selectReviewList (Map<String, Object> map) throws Exception;
	
	//------ 리뷰 
	public void insertReview (Map<String, Object> map) throws Exception;
	
	public String selectReviewId (Map<String, Object> map) throws Exception;
	
	public void updateReview (Map<String, Object> map) throws Exception;
	
	public void deleteReview (Map<String, Object> map) throws Exception;
	
	public int reviewValidation(Map<String, Object> map) throws Exception;
	
	
	
	
	public String getSEQ(Map<String, Object> map) throws Exception;
}
