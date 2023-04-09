package com.giggler.giggle.dao;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface LikeDAO {

	
	
	
	public int getBoardLike(PostDTO postDTO) throws DataAccessException;
	public void insertBoardLike(PostDTO postDTO) throws DataAccessException ;
	public void deleteBoardLike(PostDTO postDTO) throws DataAccessException ;
	public void updateBoardLike(int post_no) throws DataAccessException;

}
