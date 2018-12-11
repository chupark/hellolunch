package com.helloeating.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloeating.services.impl.FoodServicelmpl;

@RestController
@RequestMapping(value="/store/")
@CrossOrigin("*")
public class FoodController {

	
	private static final Logger logger = LogManager.getLogger(FoodController.class);
	
	@Autowired
	FoodServicelmpl foodService;
	
	@RequestMapping(value = "/eat5000",
			method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5000 (@RequestParam String store_id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("store_id", store_id);
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.SelectStoreInfo(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	//TODO 상점 보관함 마이픽
	//
	@RequestMapping(value = "/eat5010",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5010 (@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.myPick(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
//TODO 상점 보관함 마이픽 저장ㅋ
	//
	@RequestMapping(value = "/eat5015",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5015 (@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.insertMyPick(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
		
//TODO 상점 보관함 마이픽 삭제
	//
	@RequestMapping(value = "/eat5017",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5017 (@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.deleteMyPick(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	//TODO 마이 올림픽 리스트
	//
	@RequestMapping(value = "/eat5020",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5020 (@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.myOlympicList(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	//TODO 올림픽 저장
	//
	@RequestMapping(value = "/eat5025",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5025 (@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}

	//TODO 베스트 올림픽 리스트
	//
	@RequestMapping(value = "/eat5030",
			method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5030 (@RequestParam String page_num) throws Exception {
		Map <String, Object> map = new HashMap<String, Object>();
		map.put("page_num", page_num);
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.bestOlympicList(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	//TODO 리뷰 리스트
	//
	@RequestMapping(value = "/eat5040",
			method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5040 (@RequestParam String store_id, String page_num) throws Exception {
		Map <String, Object> map = new HashMap<String, Object>();
		map.put("store_id", store_id);
		map.put("page_num", page_num);
		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.reviewList(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}	
	
	
	//TODO 리뷰 입력
	//
	@RequestMapping(value = "/eat5050",
			method=RequestMethod.POST,
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5050 (@RequestBody Map <String, Object> map) throws Exception {

		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.insertReview(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	/**
	 * 리뷰 수정
	 */
	@RequestMapping(value = "/eat5060",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5060 (@RequestBody Map <String, Object> map) throws Exception {

		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.updateReview(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	/**
	 * 리뷰 삭제
	 */
	@RequestMapping(value = "/eat5070",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5070 (@RequestBody Map <String, Object> map) throws Exception {

		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.deleteReview(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	
	/**
	 * 좋아용 공통
	 */
	@RequestMapping(value = "/eat5080",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5080 (@RequestBody Map <String, Object> map) throws Exception {

		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.deleteReview(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	
	/**
	 * 좋아용 공통
	 */
	@RequestMapping(value = "/eat5090",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<Map<String, Object>> eat5090 (@RequestBody Map <String, Object> map) throws Exception {

		logger.info(map);
		Map <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = foodService.deleteReview(map);
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
}
