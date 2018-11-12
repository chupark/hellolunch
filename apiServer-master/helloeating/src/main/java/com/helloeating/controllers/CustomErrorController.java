package com.helloeating.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController  {
	@RequestMapping("/error")
	public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
		int httpErrorCode = getErrorCode(request);
	    Map <String, Object> resultMap = new HashMap<String, Object>();
	    /*if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    } else {
	    	return "hello";
	    }
	    return "error";*/
		resultMap.put("resCode", httpErrorCode);
		resultMap.put("resMsg", "error-" + httpErrorCode);
		resultMap.put("result", "");
		return new ResponseEntity <Map<String, Object>> (resultMap, HttpStatus.OK);
	}
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
    
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}


