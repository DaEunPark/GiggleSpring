package com.giggler.giggle.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageVO;

@Repository
public class ChatDAOImpl implements ChatDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "com.giggler.giggle.Chat";
	
	@Override
	public void createRoom(ChatRoomDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("createRoom");
		session.insert(namespace+".createRoom" , dto);
		System.out.println("createRoom2");
	}



	@Override
	public ChatRoomDTO isRoom(ChatRoomDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
		ChatRoomDTO roomvo = null;
		roomvo = session.selectOne(namespace+".isRoom", dto);
		System.out.println("ss");
		System.out.println(roomvo);
		
		return roomvo;
	}



	@Override
	public void insertMessage(MessageVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(namespace+".insertMessage" , vo);
	}



	@Override
	public String getProfile(String str) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getProfile" , str);
	}



	@Override
	public String getName(String str) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getName" , str);
	}



	@Override
	public List<MessageVO> getMessageList(String str) throws Exception {
		// TODO Auto-generated method stub

			return session.selectList(namespace+".getMessageList" , str);
		
		
	}



	@Override
	public List<ChatRoomDTO> getRoomList(String str) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getRoomList",str);
	}



	@Override
	public MessageVO getRecentMessage(String str) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getRecentMessage" , str);
	}



	@Override
	public List<ChatRoomDTO> getRoomListTutor(String str) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getRoomListTutor" , str);
	}



	@Override
	public void updateReadTime(String user_nick) throws Exception {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String, Object> ();
		
		map.put("USER_user_nick", user_nick);
		session.update(namespace+".updateReadTime" , map);
	}



	@Override
	public int getUnReadCount(String user_nick) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object> ();
		
		map.put("USER_user_nick", user_nick);
				
		return session.selectOne(namespace+".getUnReadCount" , map);
	}



	@Override
	public int getAllCount(String str) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object> ();
		
		map.put("USER_user_nick", str);
		if(session.selectOne(namespace+".getAllCount" ,map) ==null) {
			return 0;
		}else {
			return session.selectOne(namespace+".getAllCount" ,map);
		}
		
	}

	
}
