package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component
public class ChatRoomDTO {

	private int chatroom_no;
	private String USER_user_nick;
	
	public int getChatroom_no() {
		return chatroom_no;
	}
	public void setChatroom_no(int chatroom_no) {
		this.chatroom_no = chatroom_no;
	}
	public String getUSER_user_nick() {
		return USER_user_nick;
	}
	public void setUSER_user_nick(String uSER_user_nick) {
		USER_user_nick = uSER_user_nick;
	}
	@Override
	public String toString() {
		return "ChatRoomVO [chatroom_no=" + chatroom_no + ", USER_user_nick=" + USER_user_nick + "]";
	}
	
}
