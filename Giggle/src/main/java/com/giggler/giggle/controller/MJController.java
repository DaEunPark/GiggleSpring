package com.giggler.giggle.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageDTO;
import com.giggler.giggle.dto.UserDTO;
import com.giggler.giggle.service.MJService;

@CrossOrigin
@RestController
@RequestMapping("/mj")
public class MJController {
	
	@Inject
	private MJService mjService;
	
	//이메일 중복 확인하기========================================================
	@GetMapping("/emailCheck/{user_email}")
	public int emailCheck(@PathVariable String user_email) throws Exception {
		System.out.println("MJController의 emailCheck()" + user_email);
		
		return mjService.emailCheck(user_email);
	}
	
	//닉네임 중복 확인하기========================================================
	@GetMapping("/nickCheck/{user_nick}")
	public int nickCheck(@PathVariable String user_nick) throws Exception {
		System.out.println("MJController의 nickCheck()" + user_nick);
		
		return mjService.nickCheck(user_nick);
	}	
	
	//회원가입 처리하기 ================================================
	@PostMapping("/register")
	public UserDTO userRegister(@RequestBody UserDTO userDTO, HttpServletRequest request) throws Exception {
		System.out.println("MJController의 회원가입 처리하기" + userDTO);
		
		if(mjService.userRegister(userDTO) == 1 ) {
			//회원 등록 성공시, 해당 userDTO 객체를 다시 가져와서 리턴해준다.
			UserDTO userDTONew = mjService.getUserDTOByEmail(userDTO.getUser_email());
			return userDTONew;
		} else {
			return null;
		}
	}
	
	//네이버 로그인 토큰 확인
	@GetMapping("/naverLogin/{naver_token}")
	public UserDTO naverLogin(@PathVariable String naver_token) throws Exception {
		System.out.println("MJController의 naverLogin() " + naver_token);
		
		return mjService.naverLogin(naver_token);
	}
	
	//회원 번호에 해당하는 알람 리스트 가져오기======================================
	@GetMapping("/alarmList/{user_no}")
	public List<AlarmDTO> getAlarmListByUserNo (@PathVariable int user_no) throws Exception {
		System.out.println("MJController의 getAlarmListByUserNo() " + user_no);
		
		List<AlarmDTO> alarmList = mjService.getAlarmListByUserNo(user_no);
		
		return alarmList;
	}
	
	//회원 번호에 해당하는 채팅방 리스트 가져오기===========================================
	@GetMapping("/chatRoomList/{user_no}")
	public List<ChatRoomDTO> getChatRoomListByUserNo (@PathVariable int user_no) throws Exception {
		System.out.println("MJController의 getAlarmListByUserNo() " + user_no);
		
		return mjService.getChatRoomListByUserNo(user_no);
	}
	
	//회원번호에 해당하는 메세지 유무를 N으로 바꾸기===========================================
	@GetMapping("/updateUserMessageYN/{user_no}")
	public int updateUserMessageYN(@PathVariable int user_no) throws Exception {
		System.out.println("MJController의 updateUserMessageYN() " + user_no);
		
		return mjService.updateUserMessageYN(user_no);		
	}
	
	//키워드로 회원 검색하기============================================================
	@PostMapping("/searchUser")
	public List<UserDTO> searchUser(@RequestBody Map<String, Object> map) throws Exception {
		//System.out.println("MJController의 searchUser() " + keyword + " user_no:" + user_no);
		System.out.println("키워드: " + map.get("keyword") + " 횐번: " + map.get("user_no"));
		
		return mjService.searchUser(map);
	}

	//두명의 유저번호가 일치하는 채팅방 데이터 가져오기==========================================
	@PostMapping("/getChatRoom")
	public ChatRoomDTO getChatRoom(@RequestBody ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MJController의 getChatRoom() " + chatRoomDTO);
		
		return mjService.getChatRoom(chatRoomDTO);
	}
	
	//채팅방번호에 해당하는 메세지 리스트 가져오기=============================================
	@PostMapping("/getMessageList")
	public List<MessageDTO> getMessageList(@RequestBody MessageDTO messageDTO) throws Exception {
		System.out.println("MJController의 getMessageList() " + messageDTO);
		
		return mjService.getMessageList(messageDTO);
	}
	
	//채팅방 번호에 메세지 추가하기===========================================================
	@PostMapping("/addMessage")
	public int addMessage(@RequestBody MessageDTO messageDTO) throws Exception {
		System.out.println("MJController의 addMessage() " + messageDTO);
		
		return mjService.addMessage(messageDTO);		
	}
	
	//채팅방 나가기===========================================================================
	@PostMapping("/deleteChatRoom")
	public int deleteChatRoom(@RequestBody ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MJController의 deleteChatRoom() " + chatRoomDTO);
		
		return mjService.deleteChatRoom(chatRoomDTO);
	}
	
}
