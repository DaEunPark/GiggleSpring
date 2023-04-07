package com.giggler.giggle.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class MessageDTO {

	private int message_no;				//메세지 번호
	private int chatroom_no;			//해당 메세지의 채팅방 번호
	private int user_no;				//보낸 유저 번호
	private String message_content;		//보낸 메세지 내용
	private Timestamp message_sendtime;	//보낸 시간
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public int getChatroom_no() {
		return chatroom_no;
	}
	public void setChatroom_no(int chatroom_no) {
		this.chatroom_no = chatroom_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Timestamp getMessage_sendtime() {
		return message_sendtime;
	}
	public void setMessage_sendtime(Timestamp message_sendtime) {
		this.message_sendtime = message_sendtime;
	}
	@Override
	public String toString() {
		return "MessageDTO [message_no=" + message_no + ", chatroom_no=" + chatroom_no + ", user_no=" + user_no
				+ ", message_content=" + message_content + ", message_sendtime=" + message_sendtime + "]";
	}
	
	
	
}
