package com.helloeating.services;

import java.util.Map;

public interface UserService {

	/**
	 * 회원가입
	 * @param map ID, PW
	 * @return 
	 * @throws Exception
	 */
	//public Map <String, Object> eat1000(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> eat1000 (Map<String, Object> map) throws Exception; 
	
	/**
	 * 토큰생성
	 * @return 로그인 토큰
	 * @throws Exception
	 */
	public String makeToken () throws Exception;
	
	/**
	 * id 중복체크
	 * @param map id
	 * @return 0 false , 1 true
	 * @throws Exception
	 */
	public int idDuplication(String id) throws Exception; 
	
	/**
	 *  로그인 후 토큰 생성
	 *  @Param map : id, password
	 *  @return 로그인토큰 
	 *  @throws Exception
	 */
	public Map<String, Object> login (Map<String, Object> map) throws Exception;
	
	/**
	 * id, pw가 맞는지 체크
	 * @param String id
	 * @param String password
	 * @return 0 false, 1 true
	 * @throws Exception
	 */
	public int idPwCheck (Map<String, Object> map) throws Exception;
	
	
	/**
	 * 로그인토큰 업데이트
	 * @param map id
	 * @throws Exception
	 */
	public void updateLoginToken(Map<String, Object> map) throws Exception;
	
		
	
	
	public Map<String, Object> updateMember(Map<String, Object> map) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param map id, password, loginToken
	 * @throws Exception
	 */
	public void updateMemberInfo(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectMemberInfo(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 로그인
	 * @param map id, password, deviceToken
	 * @throws Exception
	 */
	public void updateDevideToken(Map<String, Object> map) throws Exception;
	
	/**
	 * 마지막 로그인날짜 업뎃
	 * @param map id, password, deviceToken
	 * @throws Exception
	 */
	public void updateLastLogin(Map<String, Object> map) throws Exception;
}
