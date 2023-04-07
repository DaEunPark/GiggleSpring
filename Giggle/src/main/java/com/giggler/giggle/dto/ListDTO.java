package com.giggler.giggle.dto;


import org.springframework.stereotype.Component;

@Component("listDTO")
public class ListDTO {

	//메인 피드 목록 
	private int post_no;  	
	private int user_no;
	private String user_nick;
	private String profile_image; 	 
	private String text_content;
	private String post_date;
	private int like_cnt;
	private int comment_cnt;
	private int share_cnt;
	private String post_link;
	
	//검색 
	private String keyword;
	
	

	public int getShare_cnt() {
		return share_cnt;
	}

	public void setShare_cnt(int share_cnt) {
		this.share_cnt = share_cnt;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public int getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}

	public String getPost_link() {
		return post_link;
	}

	public void setPost_link(String post_link) {
		this.post_link = post_link;
	}

	@Override
	public String toString() {
		return "ListDTO [post_no=" + post_no + ", user_no=" + user_no + ", user_nick=" + user_nick + ", profile_image="
				+ profile_image + ", text_content=" + text_content + ", post_date=" + post_date + ", like_cnt="
				+ like_cnt + ", comment_cnt=" + comment_cnt + ", share_cnt=" + share_cnt + ", post_link=" + post_link
				+ ", keyword=" + keyword + "]";
	}

	
	
}//END - public class ListDTO 
