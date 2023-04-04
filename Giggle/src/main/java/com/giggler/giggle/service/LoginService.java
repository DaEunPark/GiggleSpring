package com.giggler.giggle.service;


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

}
