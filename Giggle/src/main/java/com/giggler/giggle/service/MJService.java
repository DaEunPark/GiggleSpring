package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.MJDAO;
import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageDTO;
import com.giggler.giggle.dto.UserDTO;

@Service("mjService")
public class MJService {
	
	@Inject
	MJDAO mjDAO;
	
	//이메일 중복 확인하기===========================================
	public int emailCheck(String user_email) throws Exception {
		System.out.println("MjService의 emailCheck()");
		
		return mjDAO.emailCheck(user_email);
	}
	
	//닉네임 중복 확인하기========================================================
	public int nickCheck(String user_nick) throws Exception {
		System.out.println("MjService의 nickCheck()");
		
		return mjDAO.nickCheck(user_nick);
	}		
	
	//회원 정보로 회원 등록하기====================================================
	public int userRegister(UserDTO userDTO) throws Exception {
		System.out.println("MjService의 회원가입 처리 시작");
		
		return mjDAO.userRegister(userDTO);
	}

	//이메일을 가지고 UserDTO 객체 가져오기==========================================
	public UserDTO getUserDTOByEmail(String email) throws Exception {
		System.out.println("MjService의 getUserDTOByEmail()");
		
		return mjDAO.getUserDTOByEmail(email);
	}
	
	//네이버 로그인 토큰 확인=========================================================
	public UserDTO naverLogin(String naver_token) throws Exception {
		System.out.println("MjService의 naverLogin()");
		
		return mjDAO.naverLogin(naver_token);
	}
	
	//회원 번호에 해당하는 알람 리스트 가져오기======================================
	public List<AlarmDTO> getAlarmListByUserNo (int user_no) throws Exception {
		System.out.println("MjService의 getAlarmListByUserNo()");
		
		return mjDAO.getAlarmListByUserNo(user_no);
	}
	
	//회원 번호에 해당하는 채팅방 리스트 가져오기===================================
	public List<ChatRoomDTO> getChatRoomListByUserNo(int user_no) throws Exception {
		System.out.println("MjService의 getChatRoomListByUserNo()");
		
		return mjDAO.getChatRoomListByUserNo(user_no);		
	}
	
	//키워드로 유저 리스트 구하기=================================================
	public List<UserDTO> searchUser(String keyword) throws Exception {
		System.out.println("MjService의 searchUser()");
		
		//상대방이 나를 차단했거나, 내가 차단한 사람의 정보는 빼준다.
		
		return mjDAO.searchUser(keyword);
	}
	
	//두개의 유저 번호로 채팅방 정보 가져오기=======================================
	public ChatRoomDTO getChatRoom(ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MjService의 getChatRoom()");
		
		return mjDAO.getChatRoom(chatRoomDTO);
	}
	
	//채팅방 번호에 해당하는 메세지 리스트 가져오기==================================
	public List<MessageDTO> getMessageList(int chatroom_no) throws Exception {
		System.out.println("MjService의 getMessageList()");
		
		return mjDAO.getMessageList(chatroom_no);		
	}
	
	//채팅방에 메세지 추가하기=======================================================
	public int addMessage(MessageDTO messageDTO) throws Exception {
		System.out.println("MjService의 addMessage()");
		
		return mjDAO.addMessage(messageDTO);		
	}

}
