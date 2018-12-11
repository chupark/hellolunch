package com.helloeating.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	public void InsertMember(Map <String, Object> map) throws Exception;

	public int SelectLoginToken (Map <String, Object> map) throws Exception;
	
	public int idDuplication (String id) throws Exception;
		
	public int idPwCheck (Map<String, Object> map) throws Exception;
	
	public void updateLoginToken(Map<String, Object> map) throws Exception;
	
	public void updateMemberInfo(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectMemberInfo(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> updateDeviceToken (Map<String, Object> map) throws Exception;
	
	public Map<String, Object> updateLastLogin (Map<String, Object> map) throws Exception;
}
