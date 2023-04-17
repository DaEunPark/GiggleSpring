package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.giggler.giggle.controller.PostUploadController;
import com.giggler.giggle.dao.PostUploadDAO;
import com.giggler.giggle.dto.ImageDTO;
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
	public ListDTO postDetail(PostDTO postDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.postDetail(postDTO);
	}

	@Override
	public int currentPostNo(PostDTO postDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.currentPostNo(postDTO);
	}

	@Override
	public int uploadImage(ImageDTO imageDTO) throws DataAccessException {
		return postUploadDAO.uploadImage(imageDTO);
		
	}

	@Override
	public List<ImageDTO> postImages(ImageDTO imageDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.postImages(imageDTO);
	}

	@Override
	public int deletePostImages(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.deletePostImages(post_no);
	}

	@Override
	public int deletePost(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.deletePost(post_no);
	}

	@Override
	public int deleteImage(String imagepath) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.deleteImage(imagepath);
	}

	@Override
	public int updatePost(PostDTO postDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.updatePost(postDTO);
	}

	@Override
	public int beforeDeleteImage(String imagepath) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.beforeDeleteImage(imagepath);
	}

	@Override
	public int cancelUpdate(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return postUploadDAO.cancelUpdate(post_no);
	}

}
