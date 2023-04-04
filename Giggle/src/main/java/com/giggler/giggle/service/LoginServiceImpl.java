package com.giggler.giggle.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.LoginDAO;
import com.giggler.giggle.dto.UserDTO;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO userCheck(UserDTO userDTO) throws Exception {
		
		logger.info("LoginService에서 userCheck()실행....");
		
		return loginDAO.userCheck(userDTO);
	}

	//----------------------------------------------------------------------------------//
	// 아이디찾기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO searchId(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 searchId()실행...");
		
		return loginDAO.searchId(userDTO);
	}

	//----------------------------------------------------------------------------------//
	// 비밀번호찾기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO searchPwd(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 searchPwd()실행...");
		
		return loginDAO.searchPwd(userDTO);
	}

}
