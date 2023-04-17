package com.giggler.giggle.service;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface LikeService {



	
	public void insertBoardLike(PostDTO postDTO) throws DataAccessException;
    public void deleteBoardLike(PostDTO postDTO) throws DataAccessException ;
	public  int getBoardLike(PostDTO postDTO) throws DataAccessException;
		
	

}
