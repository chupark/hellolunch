package com.helloeating.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeyToLower {

	   /**  Map의 key값들이 대문자로 들어있을때 대문자의 key값을 소문자의 key값으로 바꾸고 value는 동일하게 유지해준다 
     * @param   Map
     * @return 소문자로 수정된 키값
     * 
     */
 public static Map<String, Object> changeToLowerMapKey(Map<String, Object> map){
   Map<String, Object> origin = map;
   Map<String, Object> temp = new HashMap<String, Object>();   
   
   Set<String> set = origin.keySet();
   Iterator<String> e = set.iterator();

   while(e.hasNext()){
     String key = e.next();
     Object value = (Object) origin.get(key);

     temp.put(key.toLowerCase(), value);
   }

   origin = null;
  return temp;
 }

 public static List<Map<String, Object>> changeToLowerListMapKey(List<Map<String, Object>> map){
	   List<Map<String, Object>> origin = map;
	   Map<String, Object> temp = new HashMap<String, Object>();   
	   
	   /*Set<String> set = origin.keySet();
	   Iterator<String> e = set.iterator();

	   while(e.hasNext()){
	     String key = e.next();
	     Object value = (Object) origin.get(key);

	     temp.put(key.toLowerCase(), value);
	   }

	   origin = null;*/
	  return null;
	 }
 
}
