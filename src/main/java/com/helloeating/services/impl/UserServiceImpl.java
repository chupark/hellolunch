package com.helloeating.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helloeating.common.Const;
import com.helloeating.mapper.UserMapper;
import com.helloeating.services.UserService;
import com.helloeating.util.KeyToLower;
import com.helloeating.util.MakeResult;
import com.helloeating.util.Validation;

@Component
public class UserServiceImpl implements UserService{

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	MakeResult makeResult = new MakeResult();
	
	@Autowired
	UserMapper userMapper;
	
	//회원가입 후 토큰 생성
	@Override
	public Map<String, Object> eat1000(Map<String, Object> map) throws Exception {
		logger.info(map);
		
		Map<String, Object> result = new HashMap<String,Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		
		// TODO Validation 
		String pkeys[] = {"id","nickname","password","password2", "marketing_agree", "reg_gb"};
		
			//E0001
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("dtd통과못함");
			result = makeResult.resultMap(Const.EConst.E0001, msg);
			return result;
		}
		logger.info("필수값 validation  통과");
		String chkId = map.get("id").toString();
			//E0002
		if(chkId.length() >= 30 ) {
			logger.error("id 30바이트 이상");
			result = makeResult.resultMap(Const.EConst.E0002, msg);
			return result;
		}
		logger.info("30글자 통과");
			//E0003
		if (idDuplication(chkId) > 0) {
			logger.error("id 중복");
			result = makeResult.resultMap(Const.EConst.E0003, msg);
			return result;
		}
		logger.info("id 중복 validation  통과");
			//E0004
		if (!map.get("password").toString().equals(map.get("password2").toString())) {
			logger.error("패스워드 미일치");
			result = makeResult.resultMap(Const.EConst.E0004, msg);
			return result;
		}
		
		// S0001
		// TODO 비지니스 로직
		String loginToken = makeToken();
		map.put("loginToken", loginToken);
		logger.info("로그인토큰 맵 추가");
		// TODO DB 처리
		userMapper.InsertMember(map);
		logger.info("인서트 처리");
		// TODO return 값 만들기
		result = makeResult.resultMap(Const.EConst.S0001, msg);
		logger.info("완료");
		return result;
	}

	@Override
	public String makeToken() throws Exception {
		Map <String, Object> map = new HashMap <String, Object>();
		String loginToken = UUID.randomUUID().toString();
		map.put("loginToken", loginToken);
		
		if (userMapper.SelectLoginToken(map) > 0) {
			return makeToken();
		}		
		
		return loginToken;
	}

	@Override
	public int idDuplication(String id) throws Exception {
		// TODO Auto-generated method stub
		
		return userMapper.idDuplication(id);
	}

	
	@Override
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String,Object>();
		Map<String, Object> msg = new HashMap<String,Object>();
		
		// TODO Validation
		//E0005
		String pkeys[] = {"id","password","device_token"};
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("dtd통과못함");
			result = makeResult.resultMap(Const.EConst.E0005, msg);
			return result;
		}
		
		// TODO 비즈니스 로직
		//E0006
		if (idPwCheck(map) == 0) {
			result = makeResult.resultMap(Const.EConst.E0006, msg);
			return result;
		}
		String chkId = map.get("id").toString();
		String loginToken = UUID.randomUUID().toString();
		
		// TODO return 값 생성
		msg.put("id", chkId);
		msg.put("loginToken", loginToken);
		
		// TODO DB 처리
		//updateLastLogin(msg);
		updateLoginToken(msg);
		msg.clear();
		
		msg = selectMemberInfo(map);
		
		Map<String, Object> bannermsg = new HashMap<String,Object>();
		bannermsg.put("message", "배너메세지");
		msg.put("bannerMsg", bannermsg);
		result = makeResult.resultMap(Const.EConst.S0001, msg);
		
		return result;
	}

	@Override
	public int idPwCheck (Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		// TODO Validation
		
		// TODO DB처리
		return userMapper.idPwCheck(map);
	}

	@Override
	public void updateLoginToken(Map<String, Object> map) throws Exception {
		logger.info("맵은뭐다" + map);
		userMapper.updateLoginToken(map);
	}

	
	@Override
	public Map<String, Object> updateMember(Map<String, Object> map) throws Exception {
		Map<String, Object> result = new HashMap<String,Object>();
		// Validation
		String pkeys[] = {"id","password","login_token","nickname","ch_password","marketing_agree"};
		
		if( !Validation.mapValidation(pkeys, map)) {
			logger.error("dtd통과못함");
			result.put("error", "회원정보수정 validation 에러");
			/*throw new Exception("E0001");*/
			return result;
		}
		
		if(idPwCheck(map) == 0) {
			logger.error("dtd통과못함");
			result.put("error", "id, pw, loginToken 입력 에러");
			return result;
		}
		
		// TODO DB처리 비즈니스로직
		updateMemberInfo(map);
		
		// TODO 리턴값 생성
		result.put("id", map.get("id"));
		result.put("success", "회원정보 수정 완료");
		return result;
	}
	
	
	@Override
	public void updateMemberInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updateMemberInfo(map);
	}

	@Override
	public Map<String, Object> selectMemberInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
			
		return userMapper.selectMemberInfo(map);
	}

	@Override
	public void updateDevideToken(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updateDeviceToken(map);
	}

	@Override
	public void updateLastLogin(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

}