package com.helloeating.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

		
	//map 을 json String 으로
	public String getJsonString (Map<String, Object> haha) {
		
		JSONObject jsonObject = new JSONObject();
		for (Entry<String, Object> entry : haha.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			jsonObject.put(key, value);
		}
		
		return jsonObject.toString();
	}
	
	//String 을 map 으로
	public Map <String, Object> jsonStrToMap (String jsonString){
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap <String, Object>();
		
		try {
			map = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
