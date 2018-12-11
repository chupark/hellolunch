package com.helloeating.util;

public class PagingTools {
	public int calTotalPage (int totalRecod, int devideNum) {
		int totalPage = 0;
		
		//레코드가 0이면 총 페이지수는 0
		if(totalRecod == 0) {
			
			return totalPage;
		}
		
		//총 레코드 갯수를 디바이드로 나눈값 = 0 이면 1페이지 밖에 없음
		if(totalRecod / devideNum == 0) {
			totalPage = 1;
			return totalPage;
		}
		
		if(totalRecod % devideNum == 0) {
			totalPage = totalRecod / devideNum;
			return totalPage;
		}else {
			totalPage = totalRecod / devideNum + 1;
			return totalPage;
		}
	}
	
	public int pageConvert(String givenNum) {
		int outNum = 0;
		outNum = (Integer.parseInt(givenNum) * 5) - 5;
		return outNum;
	}
}
