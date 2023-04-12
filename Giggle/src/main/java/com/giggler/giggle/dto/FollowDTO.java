package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component("followDTO")
public class FollowDTO {
	private int user_no;
	private int follow_user;
	private String follow_date;
	public FollowDTO() {
	}
	public FollowDTO(int user_no, int follow_user) {
		this.user_no = user_no;
		this.follow_user = follow_user;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getFollow_user() {
		return follow_user;
	}
	public void setFollow_user(int follow_user) {
		this.follow_user = follow_user;
	}
	public String getFollow_date() {
		return follow_date;
	}
	public void setFollow_date(String follow_date) {
		this.follow_date = follow_date;
	}
	@Override
	public String toString() {
		return "FollowDTO [user_no=" + user_no + ", follow_user=" + follow_user + ", follow_date=" + follow_date + "]";
	}
	
	
}
