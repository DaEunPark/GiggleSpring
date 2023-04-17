package com.giggler.giggle.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.giggler.giggle.controller.PostUploadController;
import com.giggler.giggle.dao.LikeDAO;
import com.giggler.giggle.dao.PostUploadDAO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

@Service("LikeServiece")
public class LikeServiceImpl implements LikeService {
	
	private static final Logger logger = LoggerFactory.getLogger(LikeServiceImpl.class);
	
	@Inject
	private LikeDAO likeDAO;


	
	//============================================//
	 @Override
	    public void insertBoardLike(PostDTO postDTO) throws DataAccessException {
		 likeDAO.insertBoardLike(postDTO);
		 likeDAO.updateBoardLike(postDTO.getPost_no());
	    }

	    @Override
	    public void deleteBoardLike(PostDTO postDTO) throws DataAccessException {
	    	likeDAO.deleteBoardLike(postDTO);
	    	likeDAO.updateBoardLike(postDTO.getPost_no());
	    }
	    
	    @Override
	    public  int getBoardLike(PostDTO postDTO) throws DataAccessException {
	            return likeDAO.getBoardLike(postDTO);
	    }



}
