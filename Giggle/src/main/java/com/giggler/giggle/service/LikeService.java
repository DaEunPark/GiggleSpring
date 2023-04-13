package com.giggler.giggle.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.FollowDTO;
import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface LikeService {


	public int likeCount(int post_no) throws DataAccessException;
	public List<LikeDTO> likeList(int post_no) throws DataAccessException;
	public int pushLike(LikeDTO likeDTO) throws DataAccessException ;

	public int unLike(LikeDTO likeDTO) throws DataAccessException;


	
}
