package com.giggler.giggle.dto;

public class MessageDTO {
	
	private String message_no;
	private int message_room;
	private String message_senduser;
	private String message_getuser;
	private String message_sendtime;
	private String message_readtime;
	private String message_content;
	private String message_check;

	// 현재 사용자와 메세지를 주고 받는 상대방의 닉네임
	private String message_othernick;
	
	// 현재 사용자와 메세지를 주고 받는 상대방의 profile 이미지
	private String profile_image;
	
	// 현재 사용자의 닉네임
	private String user_nick;
	
	// 안 읽은 메세지 갯수
	private int unread;

	public String getMessage_no() {
		return message_no;
	}

	public void setMessage_no(String message_no) {
		this.message_no = message_no;
	}

	public int getMessage_room() {
		return message_room;
	}

	public void setMessage_room(int message_room) {
		this.message_room = message_room;
	}

	public String getMessage_senduser() {
		return message_senduser;
	}

	public void setMessage_senduser(String message_senduser) {
		this.message_senduser = message_senduser;
	}

	public String getMessage_getuser() {
		return message_getuser;
	}

	public void setMessage_getuser(String message_getuser) {
		this.message_getuser = message_getuser;
	}

	public String getMessage_sendtime() {
		return message_sendtime;
	}

	public void setMessage_sendtime(String message_sendtime) {
		this.message_sendtime = message_sendtime;
	}

	public String getMessage_readtime() {
		return message_readtime;
	}

	public void setMessage_readtime(String message_readtime) {
		this.message_readtime = message_readtime;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public String getMessage_check() {
		return message_check;
	}

	public void setMessage_check(String message_check) {
		this.message_check = message_check;
	}

	public String getMessage_othernick() {
		return message_othernick;
	}

	public void setMessage_othernick(String message_othernick) {
		this.message_othernick = message_othernick;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}
	
	
}
