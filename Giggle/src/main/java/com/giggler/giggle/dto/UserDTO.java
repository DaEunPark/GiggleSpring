package com.giggler.giggle.dto;


import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component("userDTO")
public class UserDTO {
	

	private int user_no;
	private String user_email;
	private String user_pwd;
	private String user_nick;
	private String user_birth;
	private String user_phone;
	private Timestamp user_joindate;
	private String user_location;
	private String open_yn;
	private String status_message;
	private String profile_image;
	private String back_image;
	private String naver_token;
	private String google_token;
	private int alarm_no;
	private int block_user;
	private int follow_user;
	private int follower_user;
	private int count_post;
	public int getCount_post() {
		return count_post;
	}
	public void setCount_post(int count_post) {
		this.count_post = count_post;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Timestamp getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(Timestamp user_joindate) {
		this.user_joindate = user_joindate;
	}
	public String getUser_location() {
		return user_location;
	}
	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}
	public String getOpen_yn() {
		return open_yn;
	}
	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getBack_image() {
		return back_image;
	}
	public void setBack_image(String back_image) {
		this.back_image = back_image;
	}
	public String getNaver_token() {
		return naver_token;
	}
	public void setNaver_token(String naver_token) {
		this.naver_token = naver_token;
	}
	public String getGoogle_token() {
		return google_token;
	}
	public void setGoogle_token(String google_token) {
		this.google_token = google_token;
	}
	public int getAlarm_no() {
		return alarm_no;
	}
	public void setAlarm_no(int alarm_no) {
		this.alarm_no = alarm_no;
	}
	public int getBlock_user() {
		return block_user;
	}
	public void setBlock_user(int block_user) {
		this.block_user = block_user;
	}
	public int getFollow_user() {
		return follow_user;
	}
	public void setFollow_user(int follow_user) {
		this.follow_user = follow_user;
	}
	public int getFollower_user() {
		return follower_user;
	}
	public void setFollower_user(int follower_user) {
		this.follower_user = follower_user;
	}
	@Override
	public String toString() {
		return "UserDTO [user_no=" + user_no + ", user_email=" + user_email + ", user_pwd=" + user_pwd + ", user_nick="
				+ user_nick + ", user_birth=" + user_birth + ", user_phone=" + user_phone + ", user_joindate="
				+ user_joindate + ", user_location=" + user_location + ", open_yn=" + open_yn + ", status_message="
				+ status_message + ", profile_image=" + profile_image + ", back_image=" + back_image + ", naver_token="
				+ naver_token + ", google_token=" + google_token + ", alarm_no=" + alarm_no + ", block_user="
				+ block_user + ", follow_user=" + follow_user + ", follower_user=" + follower_user + "]";
	}
	
}
