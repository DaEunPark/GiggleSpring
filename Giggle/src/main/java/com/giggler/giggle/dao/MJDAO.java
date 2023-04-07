package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageDTO;
import com.giggler.giggle.dto.UserDTO;

@Repository("registerDAO")
public class MJDAO {

	@Inject
	private SqlSession sqlSession;
	private String Namespace = "com.giggler.giggle.mj";

	//이메일 중복 확인하기===========================================
	public int emailCheck(String user_email) throws Exception {
		System.out.println("MJDAO의 emailCheck()");
		
		return sqlSession.selectOne(Namespace + ".emailCheck" , user_email);
	}	
	
	//닉네임 중복 확인하기========================================================
	public int nickCheck(String user_nick) throws Exception {
		System.out.println("MJDAO의 nickCheck()");
		
		return sqlSession.selectOne(Namespace + ".nickCheck" , user_nick);
	}		
	
	//정보를 회원 테이블에 등록하기
	public int userRegister(UserDTO userDTO) throws Exception {
		System.out.println("MJDAO의 회원가입 처리 시작");
		
		return sqlSession.insert(Namespace + ".userRegister" , userDTO);
	}
	
	//이메일을 가지고 UserDTO 객체 가져오기
	public UserDTO getUserDTOByEmail(String email) throws Exception {
		System.out.println("MJDAO의 getUserDTOByEmail 시작");
		
		return sqlSession.selectOne(Namespace + ".getUserDTOByEmail", email);
	}
	
	//네이버 로그인 토큰 확인=========================================================
	public UserDTO naverLogin(String naver_token) throws Exception {
		System.out.println("MJDAO의 naverLogin()");
		
		return sqlSession.selectOne(Namespace + ".naverLogin", naver_token);
	}	
	//회원 번호에 해당하는 알람 리스트 가져오기
	public List<AlarmDTO> getAlarmListByUserNo (int user_no) throws Exception {
		System.out.println("MJDAO의 getAlarmListByUserNo 시작");
		
		return sqlSession.selectList(Namespace + ".getAlarmListByUserNo", user_no);
	}
	
	//회원번호에 해당하는 채팅방 리스트 가져오기 + 상대방 정보 담기
	public List<ChatRoomDTO> getChatRoomListByUserNo(int user_no) throws Exception {
		System.out.println("MJDAO의 getChatRoomListByUserNo 시작");
		
		List<ChatRoomDTO> chatRoomList = sqlSession.selectList(Namespace + ".getChatRoomListByUserNo", user_no);
		
		//상대방 번호로 정보를 가져와서 담아준다.
		for(int i = 0; i < chatRoomList.size(); i++) {
			int otherUser = 0; 	//상대방 번호
			
			if(chatRoomList.get(i).getUser1() == user_no) {
				//내가 user1이면
				otherUser = chatRoomList.get(i).getUser2();	//user2가 상대방
			} else if(chatRoomList.get(i).getUser2() == user_no) {
				//내가 user2면
				otherUser = chatRoomList.get(i).getUser1();	//user1이 상대방
			}
			
			ChatRoomDTO chatRoomDTO = sqlSession.selectOne(Namespace + ".getUserForChatRoom", otherUser);
			
			chatRoomList.get(i).setUser_nick(chatRoomDTO.getUser_nick());
			chatRoomList.get(i).setProfile_image(chatRoomDTO.getProfile_image());
		}
		System.out.println("채팅방 리스트: " + chatRoomList);
		return chatRoomList;		
	}
	
	//키워드로 유저 리스트 구하기
	public List<UserDTO> searchUser(String keyword) throws Exception {
		System.out.println("MJDAO의 searchUser() 시작");
		
		return sqlSession.selectList(Namespace + ".searchUser", keyword);		
	}
	
	//두개 유저번호로 채팅방을 찾고 없으면 만든다.
	public ChatRoomDTO getChatRoom(ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MJDAO의 getChatRoom() 시작");
		
		ChatRoomDTO	chatRoom1 = sqlSession.selectOne(Namespace + ".getChatRoom", chatRoomDTO);
		System.out.println("채팅방 서치 결과: " + chatRoom1);
		
		if(chatRoom1 == null) {
			//없으면 해당 정보로 채팅방을 만든다
			if(sqlSession.insert(Namespace + ".addChatRoom", chatRoomDTO) == 1) {
				
				//만든 채팅방을 가져와서(변수 재탕)
				chatRoom1 = sqlSession.selectOne(Namespace + ".getChatRoom", chatRoomDTO);
				
				//상대방 정보를 가져와서 넣어준다.
				ChatRoomDTO imsi = sqlSession.selectOne(Namespace + ".getUserForChatRoom", chatRoomDTO.getUser1());
				chatRoom1.setUser_nick(imsi.getUser_nick());
				chatRoom1.setProfile_image(imsi.getProfile_image());
				
				return chatRoom1;
			} else {
				return null;
			}
		} else {
			return chatRoom1;
		}
	}
	
	//채팅방 번호에 해당하는 메세지 리스트 가져오기
	public List<MessageDTO> getMessageList(int chatroom_no) throws Exception {
		System.out.println("MJDAO의 getMessageList() 시작");
		
		return sqlSession.selectList(Namespace + ".getMessageList" , chatroom_no);
	}
	
	//채팅방에 메세지 추가하기
	public int addMessage(MessageDTO messageDTO) throws Exception {
		System.out.println("MJDAO의 addMessage() 시작");
		
		return sqlSession.insert(Namespace + ".addMessage" , messageDTO);		
	}
	

}
