package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component

public class CommentDTO {
	
	private int comment_no;
	private int post_no;
	private int user_no;
	private String comment_content;
	private String comment_date;
	private String profile_image;
	private String user_nick;
	
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
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
	@Override
	public String toString() {
		return "CommentDTO [comment_no=" + comment_no + ", post_no=" + post_no + ", user_no=" + user_no
				+ ", comment_content=" + comment_content + ", comment_date=" + comment_date + ", profile_image="
				+ profile_image + ", user_nick=" + user_nick + "]";
	}
	
	
	

} // End - public class CommentDTO

