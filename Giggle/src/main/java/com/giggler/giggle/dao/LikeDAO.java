package com.giggler.giggle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.FollowDTO;
import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface LikeDAO {
	
	public int likeCount(LikeDTO likeDTO) throws DataAccessException;
	public int pushLike(LikeDTO likeDTO) throws DataAccessException ;
	public int unLike(LikeDTO likeDTO) throws DataAccessException;

	

}
