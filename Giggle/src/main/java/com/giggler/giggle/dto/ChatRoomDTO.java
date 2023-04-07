package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component
public class ChatRoomDTO {

	private int chatroom_no;		//채팅방 번호
	private int user1;				//유저1 번호
	private int user2;				//유저2 번호
	private String user_nick;		//상대방 닉네임
	private String profile_image;	//상대방 프로필 사진
	private String recent_message;	//최근 대화	
	public int getChatroom_no() {
		return chatroom_no;
	}
	public void setChatroom_no(int chatroom_no) {
		this.chatroom_no = chatroom_no;
	}
	public int getUser1() {
		return user1;
	}
	public void setUser1(int user1) {
		this.user1 = user1;
	}
	public int getUser2() {
		return user2;
	}
	public void setUser2(int user2) {
		this.user2 = user2;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getRecent_message() {
		return recent_message;
	}
	public void setRecent_message(String recent_message) {
		this.recent_message = recent_message;
	}
	@Override
	public String toString() {
		return "ChatRoomDTO [chatroom_no=" + chatroom_no + ", user1=" + user1 + ", user2=" + user2 + ", user_nick="
				+ user_nick + ", profile_image=" + profile_image + ", recent_message=" + recent_message + "]";
	}

}
