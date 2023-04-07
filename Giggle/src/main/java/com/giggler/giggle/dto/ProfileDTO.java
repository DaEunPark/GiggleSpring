package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component("profileDTO")
public class ProfileDTO {
	private int user_no; 
	private String user_nick; 
	private int count_post; 
	private int follow_user; 
	private int follower_user;
	private String profile_image; 
	private String user_birth; 
	private String open_yn; 
	private String status_message; 
	private String back_image; 
	private String naver_token; 
	private String google_token;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public int getCount_post() {
		return count_post;
	}
	public void setCount_post(int count_post) {
		this.count_post = count_post;
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
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
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
	@Override
	public String toString() {
		return "ProfileDTO [user_no=" + user_no + ", user_nick=" + user_nick + ", count_post=" + count_post
				+ ", follow_user=" + follow_user + ", follower_user=" + follower_user + ", profile_image="
				+ profile_image + ", user_birth=" + user_birth + ", open_yn=" + open_yn + ", status_message="
				+ status_message + ", back_image=" + back_image + ", naver_token=" + naver_token + ", google_token="
				+ google_token + "]";
	}

	
}
