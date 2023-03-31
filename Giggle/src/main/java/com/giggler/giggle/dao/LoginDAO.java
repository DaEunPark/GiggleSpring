package com.giggler.giggle.dao;

import com.giggler.giggle.dto.UserDTO;

public interface LoginDAO {
	
	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	public int userCheck(UserDTO userDTO) throws Exception;

}
