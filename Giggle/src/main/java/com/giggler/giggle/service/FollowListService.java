package com.giggler.giggle.service;

import java.util.List;

import com.giggler.giggle.dto.FollowListDTO;

public interface FollowListService {

	// 내가 팔로우한 사람 목록
	public List<FollowListDTO> followingList(int user_no) throws Exception;
	
	//나를 팔로우한 사람 목록
	public List<FollowListDTO> followerList(int user_no) throws Exception;
	
	//내가 블락한 사람 목록
	public List<FollowListDTO> blockList(int user_no) throws Exception;
}
