package com.giggler.giggle.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.UserDTO;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	@Inject
	private SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	private static final String Namespace = "com.giggler.giggle.user";
	
	
	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO userCheck(UserDTO userDTO) throws Exception {

		logger.info("LoginDAO에서 userCheck()실행....");
		
		return sqlSession.selectOne(Namespace + ".userCheck", userDTO);

	}

	//----------------------------------------------------------------------------------//
	// 아이디찾기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO searchId(UserDTO userDTO) throws Exception {
		
		logger.info("LoginDAO에서 searchId()실행...");
		
		return sqlSession.selectOne(Namespace + ".searchId", userDTO);
	}

	//----------------------------------------------------------------------------------//
	// 비밀번호찾기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO searchPwd(UserDTO userDTO) throws Exception {
		
		logger.info("LoginDAO에서 searchPwd()실행...");
		
		return sqlSession.selectOne(Namespace + ".searchPwd", userDTO);
	}
	
	

}
