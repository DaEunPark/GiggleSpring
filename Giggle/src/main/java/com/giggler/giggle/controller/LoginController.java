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
	public int login(@RequestBody Map<String, String> info) throws Exception {
		
		logger.info("login() 실행....");
		
		int res = 0;
		
		userDTO.setUser_email(info.get("email"));
		userDTO.setUser_pwd(info.get("pwd"));
		
		int check = loginService.userCheck(userDTO);
		
		if(check == 0)	{
			System.out.println("일치하는 회원 정보가 없습니다.");
			res = 0;
		}
		else 			{
			System.out.println("로그인을 시작합니다.");
			res = 1;
		}

		return res;
		
	} // End - 로그인 정보 가져오기
	
} // End - public class LoginController











