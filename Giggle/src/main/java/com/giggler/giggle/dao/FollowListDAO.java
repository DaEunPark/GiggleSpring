package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.FollowListDTO;

public interface FollowListDAO {

	// 내가 팔로우한 목록
	public List<FollowListDTO> followingList(int user_no) throws Exception;
}
