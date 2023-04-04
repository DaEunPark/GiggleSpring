package com.giggler.giggle.dto;

import java.sql.Timestamp;

public class CommentDTO {
	
	private int comment_no;
	private int post_no;
	private int user_no;
	private String comment_content;
	private Timestamp comment_date;
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
	public Timestamp getComment_date() {
		return comment_date;
	}
	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "CommentDTO [comment_no=" + comment_no + ", post_no=" + post_no + ", user_no=" + user_no
				+ ", comment_content=" + comment_content + ", comment_date=" + comment_date + "]";
	}
	

} // End - public class CommentDTO
