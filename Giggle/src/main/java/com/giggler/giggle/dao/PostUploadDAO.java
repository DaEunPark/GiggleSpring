package com.giggler.giggle.dao;

import org.springframework.dao.DataAccessException;

import com.giggler.giggle.dto.PostDTO;

public interface PostUploadDAO {

	int uploadPost(PostDTO postDTO) throws DataAccessException;

}
