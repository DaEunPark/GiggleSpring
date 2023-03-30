package com.giggler.giggle.service;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.PostDTO;

public interface PostUploadService {

	int uploadPost(PostDTO postDTO) throws DataAccessException;

}
