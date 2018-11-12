package com.helloeating.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Validation {
	
	private static final Logger logger = LogManager.getLogger(Validation.class);
	
	public static boolean mapValidation(String[] keys, Map<String, Object> map) {
		
		for(String key : keys) {
			if(map.get(key) == null) {
				logger.info("키 누락 : " + key);
				return false;
			}
			
			String temp = map.get(key).toString();
			
			if(StringUtils.isEmpty(temp)) {
				logger.info(key + "의 값 누락 ");
				return false;
			}
		}
		logger.info("Validation 통과");		
		return true;
	}
	
}