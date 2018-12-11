package com.helloeating.common;

import lombok.Getter;

public class Const {
	public enum TARGET_TYPE {
		S("store"),
		O("olympic"),
		R("");
		
		 @Getter
		   private final String targetType;
		   
		   private TARGET_TYPE(String targetType)    {
		       this.targetType = targetType;
		   }
	}
	
	public enum PICK_TYPE {
		LIKE("L"),
		PICK("P");
		
		 @Getter
		   private final String pickType;
		   
		   private PICK_TYPE(String pickType)    {
		       this.pickType = pickType;
		   }
		   
		   public static PICK_TYPE getValue1(String pickType) {
			   
			   for(PICK_TYPE e : PICK_TYPE.values()) {
				   if(e.pickType.equals(pickType)) {
					   return e;
				   }
			   }
			   return null;
		   }
		
	}
	
	public enum TABLE {
		REVIEW("REVIEW");
		
		 @Getter
		   private final String table;
		   
		   private TABLE(String table)    {
		       this.table = table;
		   }
	}
	
	public enum EConst {
		   
		   S0001("S0001", "정상 처리 되었습니다."),
		   //회원가입
		   E0001("E0001", "회원가입 필수값이 누락되었습니다."),
		   E0002("E0002", "ID 길이는 30자 이하 입니다."),
		   E0003("E0003", "중복 ID 입니다."),
		   E0004("E0004", "확인 비밀번호가 같지 않습니다."),
		   //로그인
		   E0005("E0005", "로그인 필수값이 누락되었습니다."),
		   E0006("E0006", "id 또는 pw 에러"),
		   
		   //스토어
		   E5000("E5000", "스토어 조회 필수값이 누락되었습니다."),
		   
		   //마이픽
		   E5010("E5010", "마이픽 필수값이 누락되었습니다."),
		   E5060("E5060", "해당 회원이 쓴 글이 아님."),
		   
		   //마이 올림픽 리스트
		   E5020("E5020", "마이픽 필수값이 누락되었습니다."),
		   
		   E10000("E10000", "필수값 누락");
			
		   @Getter
		   private final String code;
		   @Getter
		   private final String message;
		   
		   private EConst(String code, String message)    {
		       this.code = code;
		       this.message = message;
		   }
		   
		  /* public static String getValueOf(Const errCode) {
			   String errMsg = "";
			   for(Const e : Const.values()){
				   if(e == errCode) {
					   errMsg = e.message;
				   }
				  
		       }
			   return errMsg;
		   }
		   
		   public static void main (String args[]) {
			  
			   System.out.println(Const.getValueOf(Const.E0001));
			   
		   }*/
			
		}
	
}

