package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component("LikeDTO")
public class LikeDTO {
	private int post_no;
	private int user_no;
	private int like_no;
	private int like_cnt;
	
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
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	@Override
	public String toString() {
		return "LikeDTO [post_no=" + post_no + ", user_no=" + user_no + ", like_no=" + like_no + ", like_cnt="
				+ like_cnt + "]";
	}
	
	

	
	
}