package com.giggler.giggle.dao;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.FollowDTO;

public interface FollowDAO {

	int follow(FollowDTO followDTO) throws DataAccessException;

	int isFollowing(FollowDTO followDTO) throws DataAccessException;

	int unfollow(FollowDTO followDTO) throws DataAccessException;

}
