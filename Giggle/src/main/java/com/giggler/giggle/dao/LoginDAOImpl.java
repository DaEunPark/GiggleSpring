package com.giggler.giggle.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ProfileDTO;
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

	//----------------------------------------------------------------------------------//
	// 구글로그인
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO getGoogleToken(String google_token) throws Exception {
		
		logger.info("loginDAO에서 getGoogleToken()실행...");
		
		return sqlSession.selectOne(Namespace + ".getGoogleToken", google_token);
	}
	
	//----------------------------------------------------------------------------------//
	// 프로필 정보 가져오기
	//----------------------------------------------------------------------------------//
	public ProfileDTO getProfile(int user_no) throws Exception {
		
		logger.info("loginDAO에서 getProfile()실행...");
		
		return sqlSession.selectOne(Namespace + ".getProfile", user_no);
	}

}
