package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class MessageVO {

	private int message_no;
	private String message_sender;
	private String message_reciver;
	private String message_content;
	private String message_sendtime;
	private String message_readtime;
	private int CHATROOM_chatroom_no;
	private String USER_user_nick;
	
	private String user_profileImage;
	private String receiver_user_profileImage;

	private int unReadCount;

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getMessage_sender() {
		return message_sender;
	}

	public void setMessage_sender(String message_sender) {
		this.message_sender = message_sender;
	}

	public String getMessage_reciver() {
		return message_reciver;
	}

	public void setMessage_reciver(String message_reciver) {
		this.message_reciver = message_reciver;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
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

	public int getCHATROOM_chatroom_no() {
		return CHATROOM_chatroom_no;
	}

	public void setCHATROOM_chatroom_no(int cHATROOM_chatroom_no) {
		CHATROOM_chatroom_no = cHATROOM_chatroom_no;
	}

	public String getUSER_user_nick() {
		return USER_user_nick;
	}

	public void setUSER_user_nick(String uSER_user_nick) {
		USER_user_nick = uSER_user_nick;
	}

	public String getUser_profileImage() {
		return user_profileImage;
	}

	public void setUser_profileImage(String user_profileImage) {
		this.user_profileImage = user_profileImage;
	}

	public String getReceiver_user_profileImage() {
		return receiver_user_profileImage;
	}

	public void setReceiver_user_profileImage(String receiver_user_profileImage) {
		this.receiver_user_profileImage = receiver_user_profileImage;
	}

	public int getUnReadCount() {
		return unReadCount;
	}

	public void setUnReadCount(int unReadCount) {
		this.unReadCount = unReadCount;
	}
	
	public static MessageVO convertMessage(String source) {
		MessageVO message = new MessageVO();
		Gson gson = new Gson();
		message = gson.fromJson(source,  MessageVO.class);
		return message;
	}

	@Override
	public String toString() {
		return "MessageVO [message_no=" + message_no + ", message_sender=" + message_sender + ", message_reciver="
				+ message_reciver + ", message_content=" + message_content + ", message_sendtime=" + message_sendtime
				+ ", message_readtime=" + message_readtime + ", CHATROOM_chatroom_no=" + CHATROOM_chatroom_no
				+ ", USER_user_nick=" + USER_user_nick + ", user_profileImage=" + user_profileImage
				+ ", receiver_user_profileImage=" + receiver_user_profileImage + ",unReadCount=" + unReadCount + "]";
	}
	
	
}
