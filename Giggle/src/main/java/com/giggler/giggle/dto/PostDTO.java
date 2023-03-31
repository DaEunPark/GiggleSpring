package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component("PostDTO")
public class PostDTO {
	private int post_no;
	private int user_no;
	private String text_content;
	private String post_date;
	private String post_link;
	private int read_count;
	public PostDTO() {
	}
	public PostDTO(int post_no, int user_no, String text_content, String post_date, String post_link, int read_count) {
		this.post_no = post_no;
		this.user_no = user_no;
		this.text_content = text_content;
		this.post_date = post_date;
		this.post_link = post_link;
		this.read_count = read_count;
	}
	public PostDTO(int user_no, String text_content, String post_link) {
		this.user_no = user_no;
		this.text_content = text_content;
		this.post_link = post_link;
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
	public String getText_content() {
		return text_content;
	}
	public void setText_content(String text_content) {
		this.text_content = text_content;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public String getPost_link() {
		return post_link;
	}
	public void setPost_link(String post_link) {
		this.post_link = post_link;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	@Override
	public String toString() {
		return "PostDTO [post_no=" + post_no + ", user_no=" + user_no + ", text_content=" + text_content
				+ ", post_date=" + post_date + ", post_link=" + post_link + ", read_count=" + read_count + "]";
	}
	
}
