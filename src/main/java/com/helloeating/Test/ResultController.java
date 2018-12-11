package com.helloeating.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/result/")
public class ResultController {

		
	@RequestMapping(value = "/eat5000",

					produces="application/json")
	public ResponseEntity <String> result() {
		
		JSONArray array2 = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			String food = "";
			String id = "";
			String comment = "";
			String star = "";
			
			switch (i) {
				case 1:	
					food = "중식";
					id = "칭다오맨";
					comment = "맛없음";
					star = Integer.toString(i);
				break;
				case 2:	
					food = "일식";
					id = "유끼꼬상";
					comment = "그저 그럼";
					star = Integer.toString(i);
					break;
				case 3:	
					food = "한식";
					id = "홍길동";
					comment = "괜찮음";
					star = Integer.toString(i);
					break;
				case 4:	
					food = "뷔페식";
					id = "김뷔페";
					comment = "좋음";
					star = Integer.toString(i);
					break;
				case 5:	
					food = "호텔식";
					id = "미스터호텔";
					comment = "아주맛있음";
					star = Integer.toString(i);
					break;
			}
			
			JSONArray array = new JSONArray();
			JSONObject item = new JSONObject();
			JSONObject item2 = new JSONObject();
			item.put("location_name", "판교");
			item.put("store_name", food);
			item.put("store_location", "어디어디");
			item.put("store_star", star);
			item2.put("id", id);
			item2.put("comment", comment);
			item2.put("comment_star", star);
			array.put(item2);
			item.put("review", array);
			array2.put(item);
		}
		return new ResponseEntity<String> (array2.toString(), HttpStatus.OK);
	}
}
