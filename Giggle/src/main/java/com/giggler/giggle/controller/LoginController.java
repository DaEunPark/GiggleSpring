package com.giggler.giggle.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.ProfileDTO;
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
	ProfileDTO profileDTO;

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
	// 프로필 정보 가져오기
	//----------------------------------------------------------------------------------//
	@PostMapping("/settingProfile")
	@ResponseBody
	public ProfileDTO getProfile(@RequestBody Map<String, String> info) throws Exception {
		
		logger.info("LoginController에서 getProfile()실행....");
		
		int user_no = Integer.valueOf(info.get("user_no"));
		
		System.out.println("********************************************************");
		System.out.println("user_no = " + user_no);
		System.out.println("********************************************************");

		ProfileDTO profileDTO = loginService.getProfile(user_no);
		
		System.out.println("********************************************************");
		System.out.println("profileDTO1 = " + profileDTO);
		System.out.println("********************************************************");
		
		if(profileDTO.getBack_image() == null) {
			profileDTO.setBack_image("https://i.ibb.co/x803j8z/default.png");
		} else if(profileDTO.getProfile_image() == null) {
			profileDTO.setProfile_image("https://i.ibb.co/WBPR6Cp/kuromi.jpg");
		}

		System.out.println("********************************************************");
		System.out.println("profileDTO2 = " + profileDTO);
		System.out.println("********************************************************");
		
		return profileDTO;

	}
	
} // End - public class LoginController











