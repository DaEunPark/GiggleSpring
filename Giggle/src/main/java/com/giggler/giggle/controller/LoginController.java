package com.giggler.giggle.controller;

import java.util.List;
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

import com.giggler.giggle.dto.FollowDTO;
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
	@Autowired
	FollowDTO followDTO;
	@Autowired
	FollowController followcontroller;

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
	// 구글로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	@PostMapping("/googlelogin")
	@ResponseBody
	public UserDTO googlelogin(@RequestBody Map<String, String> info) throws Exception {
		
		logger.info("LoginController에서 googlelogin() 실행....");
		
		userDTO.setGoogle_token(info.get("google_token"));

		UserDTO userDTOS = loginService.googleUserCheck(userDTO);

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
		userDTO.setProfile_image(info.get("profile_image"));

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
	
	//----------------------------------------------------------------------------------//
	// myPage 게시글 수, 팔로워 수, 팔로잉 수
	//----------------------------------------------------------------------------------//
	@PostMapping("/profileCnt")
	@ResponseBody
	public UserDTO profileCnt(@RequestBody Map<String, String> myPage) throws Exception {
		
		logger.info("LoginController에서 profileCnt()실행...");
		
		String user_no = myPage.get("user_no");
		
		UserDTO userDTO = loginService.profileCnt(user_no);
		
		return userDTO;
	}
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(3명)
	//----------------------------------------------------------------------------------//	
	@PostMapping("/recommendFollow")
	@ResponseBody
	public List<UserDTO> recommendFollow(@RequestBody Map<String, String> userInfo) throws Exception {
		
		logger.info("LoginController에서 recommendFollow()실행..." + userInfo);
		
		String user_no = userInfo.get("user_no");
		
		List<UserDTO> recommendUser = loginService.recommendFollow(user_no);
		
		System.out.println("recommendUser = "+recommendUser);
		
		return recommendUser;		
		
	}
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(전부)
	//----------------------------------------------------------------------------------//	
	@PostMapping("/recommendFollowAll")
	@ResponseBody
	public List<UserDTO> recommendFollowAll(@RequestBody Map<String, String> userInfo) throws Exception {
		
		logger.info("LoginController에서 recommendFollow()실행...");
		
		String user_no = userInfo.get("user_no");
		
		List<UserDTO> recommendUser = loginService.recommendFollowAll(user_no);
		
		return recommendUser;		
		
	}
	
	//----------------------------------------------------------------------------------//
	// 유저 블락
	//----------------------------------------------------------------------------------//
	@PostMapping("/userBlock")
	@ResponseBody
	public void userBlock(@RequestBody Map<String, String> userInfo) throws Exception {
		
		logger.info("LoginController에서 userBlock()실행...");
		
		userDTO.setUser_no(Integer.valueOf(userInfo.get("myUser_no")));
		userDTO.setBlock_user(Integer.valueOf(userInfo.get("blockUser_no")));
		
		loginService.userBlock(userDTO);
		
		followDTO.setUser_no(Integer.valueOf(userInfo.get("myUser_no")));
		followDTO.setFollow_user(Integer.valueOf(userInfo.get("blockUser_no")));
		if(followcontroller.followCheck(followDTO) == "Y") {
			System.out.println("팔로우 돼있어서 언팔 진행..");
			loginService.unfollow(followDTO);
			loginService.unfollower(followDTO);			
		} else {
			System.out.println("팔로우 안돼있음..");
		}
		
		System.out.println("userBlock() 끝....");
	}
	
	//----------------------------------------------------------------------------------//
	// 유저 블락 체크
	//----------------------------------------------------------------------------------//
	@PostMapping("/userBlockCheck")
	@ResponseBody
	public String userBlockCheck(@RequestBody Map<String, String> userInfo) throws Exception {
		
		logger.info("LoginController에서 userBlockCheck()실행...");
		
		userDTO.setUser_no(Integer.valueOf(userInfo.get("myUser_no")));
		userDTO.setBlock_user(Integer.valueOf(userInfo.get("blockUser_no")));
		
		if(loginService.userBlockCheck(userDTO) == 0) {
			System.out.println("block아님");
			return "N";
		} else {
			System.out.println("block유저");
			return "Y";
		}
	}
		
	//----------------------------------------------------------------------------------//
	// 유저 블락 취소
	//----------------------------------------------------------------------------------//
	@PostMapping("/userBlockCancle")
	@ResponseBody
	public void userBlockCancle(@RequestBody Map<String, String> userInfo) throws Exception {
			
		logger.info("LoginController에서 userBlockCancle()실행...");
			
		userDTO.setUser_no(Integer.valueOf(userInfo.get("myUser_no")));
		userDTO.setBlock_user(Integer.valueOf(userInfo.get("blockUser_no")));
			
		loginService.userBlockCancle(userDTO);
			
		System.out.println("userBlockCancle() 끝....");
	}
	
	
	
	
} // End - public class LoginController











