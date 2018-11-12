package com.helloeating.util;

import java.util.HashMap;
import java.util.Map;

import com.helloeating.common.Const;

public class MakeResult {

	public Map<String, Object> resultMap (Const.EConst ercode, Map<String, Object> result) {
		KeyToLower keyToLower = new KeyToLower();
		
		Map<String, Object> goods = new HashMap<String,Object>();
		goods.put("resCode", ercode.getCode());
		goods.put("resMsg", ercode.getMessage());
		
		goods.put("result", keyToLower.changeToLowerMapKey(result));
		
		
		return goods;
	}
}
