package com.helloeating.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.helloeating.domain.MemberVO;
import com.helloeating.services.impl.UserServiceImpl;
import com.helloeating.util.JsonConverter;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	JsonConverter jsonConverter = new JsonConverter();
	
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = "/signup")
	public String memberRegisterForm() {
		logger.info("그냥있는페이지");
		logger.debug("df");
		logger.error("asdfasdf");
		logger.fatal("asdfasdfasdf");
		return "hello";
	}
	
	
	//로그인
	@RequestMapping(value = "/eat1000",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat1000(@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
			Map <String, Object> resultMap = new HashMap<String, Object>();
							
			resultMap = userService.login(map);
			
		return new ResponseEntity<Map<String, Object>> (resultMap, HttpStatus.OK);
	}
			
	
	@RequestMapping(value = "/eat1100",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat1100(@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
			Map <String, Object> resultMap = new HashMap<String, Object>();
			int idDuplication = userService.idDuplication(map.get("id").toString());
			
			
			resultMap.put("chkID", idDuplication);
			
		return new ResponseEntity<Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	
	//회원가입
	@RequestMapping(value = "/eat2000",
					method=RequestMethod.POST,
					consumes="application/json",
					produces="application/json")
	public ResponseEntity<Map<String, Object>> eat2000(@RequestBody Map <String, Object> map) throws Exception {
			logger.info(map);
			
			return new ResponseEntity<Map<String, Object>> (userService.eat1000(map), HttpStatus.OK);
	}
	
	//회원정보 수정
	@RequestMapping(value = "/eat2010",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<Map<String, Object>> eat2100(@RequestBody Map <String, Object> map) throws Exception {
		logger.info(map);
			Map <String, Object> resultMap = new HashMap<String, Object>();
						
			resultMap = userService.updateMember(map);
			
		return new ResponseEntity<Map<String, Object>> (resultMap, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/test")
	public ResponseEntity <String> list (){
		JSONArray array = new JSONArray();
		for (int i = 0; i <= 3; i++) {
			JSONObject item = new JSONObject();
			item.put("hello", "world");
			item.put("hello2", "world");
			array.put(item);
		}
				
		return new ResponseEntity<String>(array.toString(), HttpStatus.OK);
	}
}
