package com.giggler.giggle.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.UserDTO;
import com.giggler.giggle.service.LoginServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	UserDTO userDTO;
	@Autowired
	LoginServiceImpl loginService;

	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	@PostMapping("/login")
	@ResponseBody
	public UserDTO login(@RequestBody Map<String, String> info) throws Exception {
		
		logger.info("LoginController에서 login() 실행....");
		
		userDTO.setUser_email(info.get("email"));
		userDTO.setUser_pwd(info.get("pwd"));

		UserDTO userDTOS = loginService.userCheck(userDTO);

		System.out.println("userDTOS = " + userDTOS);
		
		if(userDTOS == null) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		return userDTOS; 
		
	} // End - 로그인 정보 가져오기
	
	//----------------------------------------------------------------------------------//
	// 아이디찾기
	//----------------------------------------------------------------------------------//
	@PostMapping("/searchId")
	@ResponseBody
	public UserDTO searchId(@RequestBody Map<String, String> searchInfo) throws Exception {
		
		logger.info("LoginController에서 searchId()실행...");
		
		userDTO.setUser_birth(searchInfo.get("birth"));
		userDTO.setUser_phone(searchInfo.get("phone"));
				
		UserDTO userDTOI = loginService.searchId(userDTO);

		System.out.println("userDTOI = " + userDTOI);
		
		return userDTOI;
	}
	
	//----------------------------------------------------------------------------------//
	// 비밀번호찾기
	//----------------------------------------------------------------------------------//
	@PostMapping("/searchPwd")
	@ResponseBody
	public UserDTO searchPwd(@RequestBody Map<String, String> searchInfo) throws Exception {
		
		logger.info("LoginController에서 searchPwd()실행...");
		
		userDTO.setUser_email(searchInfo.get("email"));
		userDTO.setUser_birth(searchInfo.get("birth"));
		userDTO.setUser_phone(searchInfo.get("phone"));
				
		UserDTO userDTOP = loginService.searchPwd(userDTO);

		System.out.println("userDTOP = " + userDTOP);
		
		return userDTOP;
	}
	
} // End - public class LoginController











