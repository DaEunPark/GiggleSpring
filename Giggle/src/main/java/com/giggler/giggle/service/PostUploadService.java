package com.giggler.giggle.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.ImageDTO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface PostUploadService {

	int uploadPost(PostDTO postDTO) throws DataAccessException;

	ListDTO postDetail(int post_no) throws DataAccessException;

	int currentPostNo(PostDTO postDTO) throws DataAccessException;

	int uploadImage(ImageDTO imageDTO) throws DataAccessException;

	List<ImageDTO> postImages(int post_no) throws DataAccessException;

	int deletePostImages(int post_no) throws DataAccessException;

	int deletePost(int post_no) throws DataAccessException;

}
