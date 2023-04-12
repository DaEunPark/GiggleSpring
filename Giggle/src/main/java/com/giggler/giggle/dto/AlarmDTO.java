package com.giggler.giggle.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class AlarmDTO {

	private int alarm_no;
	private int user_no;	//내 회원 번호
	private int alarm_user; //상대방 회원 번호
	private String alarm_user_nick; //상대방 닉네임
	private String alarm_user_profile;	//상대방 프로필
	private String alarm_type;	//알람 종류(1:팔로우, 2:좋아요, 3:댓글)
	private String alarm_date;
	private int post_no;		//해당 게시글 번호
	public int getAlarm_no() {
		return alarm_no;
	}
	public void setAlarm_no(int alarm_no) {
		this.alarm_no = alarm_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getAlarm_user() {
		return alarm_user;
	}
	public void setAlarm_user(int alarm_user) {
		this.alarm_user = alarm_user;
	}
	public String getAlarm_user_nick() {
		return alarm_user_nick;
	}
	public void setAlarm_user_nick(String alarm_user_nick) {
		this.alarm_user_nick = alarm_user_nick;
	}
	
	public String getAlarm_user_profile() {
		return alarm_user_profile;
	}
	public void setAlarm_user_profile(String alarm_user_profile) {
		this.alarm_user_profile = alarm_user_profile;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getAlarm_date() {
		return alarm_date;
	}
	public void setAlarm_date(String alarm_date) {
		this.alarm_date = alarm_date;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "AlarmDTO [alarm_no=" + alarm_no + ", user_no=" + user_no + ", alarm_user=" + alarm_user
				+ ", alarm_user_nick=" + alarm_user_nick + ", alarm_user_profile=" + alarm_user_profile
				+ ", alarm_type=" + alarm_type + ", alarm_date=" + alarm_date + ", post_no=" + post_no + "]";
	}

}
