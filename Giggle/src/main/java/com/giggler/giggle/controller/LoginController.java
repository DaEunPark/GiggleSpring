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

import com.giggler.giggle.dto.PostDTO;
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
	@Autowired
	PostDTO postDTO;

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
	
	//----------------------------------------------------------------------------------//
	// 구글로그인
	//----------------------------------------------------------------------------------//
	@PostMapping("/googleAuth")
	@ResponseBody
	public UserDTO googleAuth(@RequestBody Map<String, String> token) throws Exception {
		
		logger.info("LoginController에서 googleAuth()실행....");
		
		String google_token = token.get("token");
		System.out.println("********************************************************");
		System.out.println("google_token = " + google_token);
		System.out.println("********************************************************");

		UserDTO userDTO = loginService.getGoogleToken(google_token);
		
		System.out.println("********************************************************");
		System.out.println("userDTO = " + userDTO);
		System.out.println("********************************************************");
		return userDTO;

	}

	
	//----------------------------------------------------------------------------------//
	// 프로필 정보 수정하기
	//----------------------------------------------------------------------------------//
	@PostMapping("/updateProfile")
	@ResponseBody
	public UserDTO updateProfile(@RequestBody Map<String, String> info) throws Exception {
		
		logger.info("LoginController에서 updateProfile()실행....");
		
		userDTO.setUser_no(Integer.valueOf(info.get("user_no")));
		userDTO.setUser_nick(info.get("user_nick"));
		userDTO.setStatus_message(info.get("status_message"));
		userDTO.setUser_location(info.get("user_location"));
		userDTO.setUser_birth(info.get("user_birth"));

		if(loginService.updateProfile(userDTO) == 1) {
			userDTO.setUser_no(Integer.valueOf(info.get("user_no")));
			UserDTO userDTOU = loginService.updateCheck(userDTO);
			return userDTOU;
		} else {
			UserDTO userDTOU = loginService.updateCheck(userDTO);
			return userDTOU;
		}
	}

	//----------------------------------------------------------------------------------//
	// mypage / notmypage알아내기
	//----------------------------------------------------------------------------------//
	@PostMapping("/whichProfile")
	public PostDTO whichProfile(@RequestBody Map<String, String> param) throws Exception {
		
		logger.info("LoginController에서 whichProfile()실행....");
		logger.info("post_no = " + param.get("post_no"));
		
		int post_no = Integer.valueOf(param.get("post_no"));
		
		PostDTO postDTO = loginService.whichProfile(post_no);

		return postDTO;
	}
	
	//----------------------------------------------------------------------------------//
	// 다른 사람 프로필 가져오기
	//----------------------------------------------------------------------------------//
	@PostMapping("/otherProfile")
	public UserDTO otherProfile(@RequestBody Map<String, String> user_no) throws Exception {
		
		logger.info("LoginController에서 otherProfile()실행....");

		userDTO.setUser_no(Integer.valueOf(user_no.get("user_no")));
		
		UserDTO userDTOY = loginService.otherProfile(userDTO);
				
		return userDTOY;
		
	}
	
} // End - public class LoginController











