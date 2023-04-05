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
	private String open_yn = "Y";	//기본값 Y 세팅
	private String status_message;
	private String profile_image;
	private String back_image;
	
	private String naver_token;
	private String google_token;


	public String getGoogle_token() {
		return google_token;
	}
	public void setGoogle_token(String google_token) {
		this.google_token = google_token;
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

	public Timestamp getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(Timestamp user_joindate) {
		this.user_joindate = user_joindate;
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
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getNaver_token() {
		return naver_token;
	}
	public void setNaver_token(String naver_token) {
		this.naver_token = naver_token;
	}
	@Override
	public String toString() {
		return "UserDTO [user_no=" + user_no + ", user_email=" + user_email + ", user_pwd=" + user_pwd + ", user_nick="
				+ user_nick + ", user_birth=" + user_birth + ", user_phone=" + user_phone + ", user_joindate="
				+ user_joindate + ", open_yn=" + open_yn + ", status_message=" + status_message + ", profile_image="
				+ profile_image + ", back_image=" + back_image + ", naver_token=" + naver_token + ", googleToken="
				+ google_token + "]";
	}
	
}
