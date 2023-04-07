package com.giggler.giggle.service;

import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.dto.UserDTO;

public interface LoginService {

	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	public UserDTO userCheck(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 아이디찾기
	//----------------------------------------------------------------------------------//
	public UserDTO searchId(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 비밀번호찾기
	//----------------------------------------------------------------------------------//
	public UserDTO searchPwd(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 구글로그인
	//----------------------------------------------------------------------------------//
	public UserDTO getGoogleToken(String google_token) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 프로필 정보 수정하기
	//----------------------------------------------------------------------------------//
	public int updateProfile(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 수정한 프로필 정보 가져오기
	//----------------------------------------------------------------------------------//
	public UserDTO updateCheck(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// mypage / notmypage알아내기
	//----------------------------------------------------------------------------------//
	public PostDTO whichProfile(int post_no) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 다른 사람 프로필 가져오기
	//----------------------------------------------------------------------------------//
	public UserDTO otherProfile(UserDTO userDTO) throws Exception;

}
