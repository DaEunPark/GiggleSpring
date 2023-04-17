package com.giggler.giggle.service;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.LikeDTO;

public interface LikeService {


	public int likeCount(LikeDTO likeDTO) throws DataAccessException;
	public int pushLike(LikeDTO likeDTO) throws DataAccessException ;
	public int unLike(LikeDTO likeDTO) throws DataAccessException;

	
}
