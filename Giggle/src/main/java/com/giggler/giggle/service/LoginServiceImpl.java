package com.giggler.giggle.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.LoginDAO;
import com.giggler.giggle.dto.FollowDTO;
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
	// 구글로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	@Override
	public UserDTO googleUserCheck(UserDTO userDTO) throws Exception {
		
		logger.info("LoginService에서 googleUserCheck()실행....");
		
		return loginDAO.googleUserCheck(userDTO);
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

	//----------------------------------------------------------------------------------//
	// 프로필 사진 업데이트하기
	//----------------------------------------------------------------------------------//
	@Override
	public int picUpdate(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 picUpdate()실행...");
		
		return loginDAO.picUpdate(userDTO);
	}
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(3명)
	//----------------------------------------------------------------------------------//
	@Override
	public List<UserDTO> recommendFollow(String user_no) throws Exception {
		
		logger.info("loginService에서 recommendFollow()실행...");
		
		return loginDAO.recommendFollow(user_no);
	}
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(전부)
	//----------------------------------------------------------------------------------//
	@Override
	public List<UserDTO> recommendFollowAll(String user_no) throws Exception {
		
		logger.info("loginService에서 recommendFollow()실행...");
		
		return loginDAO.recommendFollowAll(user_no);
	}

	//----------------------------------------------------------------------------------//
	// 유저 블락
	//----------------------------------------------------------------------------------//
	@Override
	public int userBlock(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 userBlock()실행...");
		
		return loginDAO.userBlock(userDTO);
		
	}

	//----------------------------------------------------------------------------------//
	// 유저 블락 체크
	//----------------------------------------------------------------------------------//
	@Override
	public int userBlockCheck(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 userBlockCheck()실행...");
		
		return loginDAO.userBlockCheck(userDTO);
	}
	
	//----------------------------------------------------------------------------------//
	// 유저 블락 취소
	//----------------------------------------------------------------------------------//
	@Override
	public int userBlockCancle(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 userBlockCancle()실행...");
		
		return loginDAO.userBlockCancle(userDTO);
		
	}

	//----------------------------------------------------------------------------------//
	// 유저블락시 => 언팔로우
	//----------------------------------------------------------------------------------//
	@Override
	public int unfollow(FollowDTO followDTO) throws Exception {
		
		logger.info("loginService에서 unfollow()실행...");
		
		return loginDAO.unfollow(followDTO);
	}

	//----------------------------------------------------------------------------------//
	// 유저블락시 => 언팔로워
	//----------------------------------------------------------------------------------//
	@Override
	public int unfollower(FollowDTO followDTO) throws Exception {
		
		logger.info("loginService에서 unfollower()실행...");
		
		return loginDAO.unfollower(followDTO);
	}
	
	//----------------------------------------------------------------------------------//
	// 내가 해당 유저에게 블락돼 있는지 체크
	//----------------------------------------------------------------------------------//
	public int amIBlockCheck(UserDTO userDTO) throws Exception {
		
		logger.info("loginService에서 amIBlockCheck()실행...");
		
		return loginDAO.amIBlockCheck(userDTO);		
	}

}
