package com.giggler.giggle.dto;

public class FollowListDTO {

	private int user_no;
	private int follow_user;
	private String follow_date;
	private String user_nick; 
	private String profile_image; 
	private String status_message;
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
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	@Override
	public String toString() {
		return "FollowListDTO [user_no=" + user_no + ", follow_user=" + follow_user + ", follow_date=" + follow_date
				+ ", user_nick=" + user_nick + ", profile_image=" + profile_image + ", status_message=" + status_message
				+ "]";
	} 
	
	
}
