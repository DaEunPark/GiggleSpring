package com.giggler.giggle.dao;

import java.util.List;
import java.util.Map;

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
			if(otherUser != 0) {
				ChatRoomDTO chatRoomDTO = sqlSession.selectOne(Namespace + ".getUserForChatRoom", otherUser);
				chatRoomList.get(i).setUser_nick(chatRoomDTO.getUser_nick());
				chatRoomList.get(i).setProfile_image(chatRoomDTO.getProfile_image());
			}
			
		}
		System.out.println("채팅방 리스트: " + chatRoomList);
		return chatRoomList;		
	}
	
	//회원번호에 해당하는 메세지 유무 업데이트======================================================
	public int updateUserMessageYN(int user_no) throws Exception {
		System.out.println("MJDAO의 updateUserMessageYN() 시작");
		
		return sqlSession.update(Namespace + ".updateUserMessageYN", user_no);			
	}
	
	//키워드로 유저 리스트 구하기
	public List<UserDTO> searchUser(Map<String, Object> map) throws Exception {
		System.out.println("MJDAO의 searchUser() 시작");
		
		return sqlSession.selectList(Namespace + ".searchUser", map);		
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
	public List<MessageDTO> getMessageList(MessageDTO messageDTO) throws Exception {
		System.out.println("MJDAO의 getMessageList() 시작");
		int chatroom_no = messageDTO.getChatroom_no();
		
		//메세지를 불러올 때(채팅방을 클릭 했을 때) 나의 새로운 메세지 유무를 바꿔준다.
		ChatRoomDTO chatRoomDTO = sqlSession.selectOne(Namespace + ".getChatRoomByRoomNo" , chatroom_no);
		
		//해당 채팅방의 user1이 나면
		if(chatRoomDTO.getUser1() == messageDTO.getUser_no()) {
			//user1의 메세지 유무를 바꿔준다.
			chatRoomDTO.setUser1_yn("N");
		} else {//해당 채팅방의 user2가 나면
			//user2의 메세지 유무를 바꿔준다.
			chatRoomDTO.setUser2_yn("N");
		}
		if(sqlSession.update(Namespace + ".updateChatUserYN", chatRoomDTO) == 1) {
			System.out.println("나의 새로운 메세지 유무 수정함: " + chatRoomDTO);
		}
		return sqlSession.selectList(Namespace + ".getMessageList" , chatroom_no);
	}
	
	//채팅방에 메세지 추가하기
	public int addMessage(MessageDTO messageDTO) throws Exception {
		System.out.println("MJDAO의 addMessage() 시작");
		
		if(sqlSession.insert(Namespace + ".addMessage" , messageDTO) == 1) {
			//상대방의 해당 채팅방 새로운 메세지 유무를 바꿔준다.
			int chatroom_no = messageDTO.getChatroom_no();
			int otherUser = 0;
			ChatRoomDTO chatRoomDTO = sqlSession.selectOne(Namespace + ".getChatRoomByRoomNo" , chatroom_no);
			if(chatRoomDTO.getUser1() == messageDTO.getUser_no()) {
				chatRoomDTO.setUser2_yn("Y");
				otherUser = chatRoomDTO.getUser2();
			} else {
				chatRoomDTO.setUser1_yn("Y");
				otherUser = chatRoomDTO.getUser1();
			}
			int result = sqlSession.update(Namespace + ".updateChatUserYN", chatRoomDTO);
			System.out.println("상대방 새로운 메세지 유무 수정함: " + chatRoomDTO);
			
			//상대방의 메세지 유무를 바꿔준다.
			result = sqlSession.update(Namespace + ".updateMessageYn" , otherUser);
			System.out.println("상대방 user테이블 새로운 메세지 유무 수정함: " + chatRoomDTO);
		} 
		
		return 1;
	}
	
	//채팅방 나가기
	public int deleteChatRoom(ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MJDAO의 deleteChatRoom() 시작");
		int result = 0;
		//채팅방 번호로 채팅방 정보를 가져온다.
		int chatroom_no = chatRoomDTO.getChatroom_no();
		ChatRoomDTO imsi = sqlSession.selectOne(Namespace + ".getChatRoomByRoomNo" , chatroom_no);
		
		//채팅방에 상대방 번호가 0이면 채팅방을 삭제한다.
		if(imsi.getUser1() == 0 || imsi.getUser2() == 0) {
			result = sqlSession.delete(Namespace + ".deleteChatRoom", chatRoomDTO);
		} else {
			//임시 채팅방 정보에 유저번호를 0으로 만든다.
			if(chatRoomDTO.getUser1() == imsi.getUser1()) {
				imsi.setUser1(0);
			} else {
				imsi.setUser2(0);
			}
			//임시채팅방 정보로 업데이트 한다.
			result = sqlSession.update(Namespace + ".deleteChatRoomUser", imsi);
		}
		
		return result;
	}
}
