package com.giggler.giggle.service;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

public interface PostUploadService {

	int uploadPost(PostDTO postDTO) throws DataAccessException;

	ListDTO postDetail(int post_no) throws DataAccessException;

	int currentPostNo(PostDTO postDTO) throws DataAccessException;

}
