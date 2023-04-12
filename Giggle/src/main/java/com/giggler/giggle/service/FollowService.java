package com.giggler.giggle.service;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.FollowDTO;

public interface FollowService {

	int follow(FollowDTO followDTO) throws DataAccessException;

	int isFollowing(FollowDTO followDTO) throws DataAccessException;

	int unfollow(FollowDTO followDTO) throws DataAccessException;

}
