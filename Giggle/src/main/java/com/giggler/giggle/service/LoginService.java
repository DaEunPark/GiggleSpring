package com.giggler.giggle.service;

import com.giggler.giggle.dto.UserDTO;

public interface LoginService {

	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	public int userCheck(UserDTO userDTO) throws Exception;

}
