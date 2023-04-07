package com.giggler.giggle.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.giggler.giggle.controller.PostUploadController;
import com.giggler.giggle.dao.PostUploadDAO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

@Service("postUploadServiece")
public class PostUploadServiceImpl implements PostUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(PostUploadServiceImpl.class);
	
	@Inject
	private PostUploadDAO postUploadDAO;

	@Override
	public int uploadPost(PostDTO postDTO) throws DataAccessException {
		
		return postUploadDAO.uploadPost(postDTO);
	}

	@Override
	public ListDTO postDetail(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.postDetail(post_no);
	}

	@Override
	public int currentPostNo(PostDTO postDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.currentPostNo(postDTO);
	}

}
