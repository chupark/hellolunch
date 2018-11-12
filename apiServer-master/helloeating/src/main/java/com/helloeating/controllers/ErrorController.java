package com.helloeating.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/error/")
public class ErrorController {

	@RequestMapping(value="/er1000")
	public String needLogin() {
		
		return "로그인이 필요합니다";
	}
	
	@RequestMapping(value = "/er1010",
			method=RequestMethod.GET,
				   produces="application/json")
	public ResponseEntity<Map<String, Object>>  needLogin2() {
		Map <String, Object> map = new HashMap <String, Object>();
		map.put("status", "eat1010");
		map.put("msg", "잘못된 토큰 또는 id");
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
