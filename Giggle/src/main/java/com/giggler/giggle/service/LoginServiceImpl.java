package com.giggler.giggle.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.LoginDAO;
import com.giggler.giggle.dto.PostDTO;
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
	
	//----------------------------------------------------------------------------------//
	// 구글로그인
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO getGoogleToken(String google_token) throws Exception {
		
		logger.info("loginService에서 getGoogleToken()실행...");
		
		return loginDAO.getGoogleToken(google_token);
	}
	
	//----------------------------------------------------------------------------------//
	// 프로필 사진 수정하기
	//----------------------------------------------------------------------------------//
	@Override
	public int updatePic(UserDTO userDTO) throws Exception {

		logger.info("loginService에서 updatePic()실행...");
		
		return loginDAO.updatePic(userDTO);
	}

	//----------------------------------------------------------------------------------//
	// 프로필 정보 수정하기
	//----------------------------------------------------------------------------------//
	@Override
	public int updateProfile(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 updateProfile()실행...");
		
		return loginDAO.updateProfile(userDTO);
	}

	//----------------------------------------------------------------------------------//
	// 수정한 프로필 정보 가져오기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO updateCheck(UserDTO userDTO) throws Exception {

		logger.info("loginService에서 updateProfile()실행...");
		
		return loginDAO.updateCheck(userDTO);
	}
	//----------------------------------------------------------------------------------//
	// mypage / notmypage알아내기
	//----------------------------------------------------------------------------------//
	@Override
	public PostDTO whichProfile(int post_no) throws Exception {
		
		logger.info("loginService에서 whichProfile()실행...");
		
		return loginDAO.whichProfile(post_no);
	}
	
	//----------------------------------------------------------------------------------//
	// 다른 사람 프로필 가져오기
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO otherProfile(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 otherProfile()실행...");
		
		return loginDAO.otherProfile(userDTO);
	}

	//----------------------------------------------------------------------------------//
	// myPage 게시글 수, 팔로워 수, 팔로잉 수
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO profileCnt(String user_no) throws Exception {
		
		logger.info("loginService에서 profileCnt()실행...");
		
		return loginDAO.profileCnt(user_no);
	}
	
	


}
