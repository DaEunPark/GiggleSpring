package com.giggler.giggle.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.MessageDTO;

@Repository
public class MessageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 메세지 리스트
	public ArrayList<MessageDTO> messageList(MessageDTO dto){
		String user_nick = dto.getUser_nick();
		
		/*
		 * 메세지 리스트에 나타낼 것들 가져오기
		 * : 가장 최근 메세지, 보낸 사람 profile 사진, 보낸 사람 닉네임
		 */
		ArrayList<MessageDTO> list = (ArrayList) sqlSession.selectList("messageList", dto);
		
		for(MessageDTO mto : list) {
			mto.setUser_nick(user_nick);
			
			// 현재 사용자가 해당 room에서 읽지 않은 메세지의 갯수를 가져온다.
			int unread = sqlSession.selectOne("count_unread", mto);
			
			// 현재 사용자가 메세지를 주고받는 상대의 profile을 가져온다.
			String profile_image = sqlSession.selectOne("get_other_profile", mto);
			
			// 안 읽은 메세지 갯수를 mto에 set한다.
			mto.setUnread(unread);
			
			// 메세지 상대의 프로필 사진을 mto에 set한다.
			mto.setProfile_image(profile_image);
			
			// 메세지 상대 nick을 세팅한다.
			if(user_nick.equals(mto.getMessage_senduser())) {
				mto.setMessage_othernick(mto.getMessage_getuser());				
			} else {
				mto.setMessage_othernick(mto.getMessage_senduser());
			}
		}
		
		return list;
	}
}
