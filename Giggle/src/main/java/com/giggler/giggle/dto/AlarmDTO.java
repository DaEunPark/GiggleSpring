package com.giggler.giggle.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class AlarmDTO {

	private int alarm_no;
	private int user_no;	//내 회원 번호
	private int alarm_user; //상대방 회원 번호
	private String alarm_type;	//알람 종류(1:팔로우, 2:좋아요, 3:댓글)
	private Timestamp alarm_date;
	private String read_yn = "N";	//알람 읽었는지 기본값 N
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
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public Timestamp getAlarm_date() {
		return alarm_date;
	}
	public void setAlarm_date(Timestamp alarm_date) {
		this.alarm_date = alarm_date;
	}
	public String getRead_yn() {
		return read_yn;
	}
	public void setRead_yn(String read_yn) {
		this.read_yn = read_yn;
	}
	@Override
	public String toString() {
		return "AlarmDTO [alarm_no=" + alarm_no + ", user_no=" + user_no + ", alarm_user=" + alarm_user
				+ ", alarm_type=" + alarm_type + ", alarm_date=" + alarm_date + ", read_yn=" + read_yn + "]";
	}
	
	
}
