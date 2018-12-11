package com.helloeating.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BaseException extends Exception{

	BaseException(String errCode) {
		
		String codeLocation = "classpath:response.xml";
		AbstractApplicationContext ctx = new  GenericXmlApplicationContext(codeLocation);
		
		System.out.println("dd" + codeLocation);
	}
	
}
