package com.giggler.giggle.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.service.PostUploadServiceImpl;

@Repository("postUploadDAO")
public class PostUploadDAOImpl implements PostUploadDAO {
	private static final Logger logger = LoggerFactory.getLogger(PostUploadDAOImpl.class);
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하자 : xml의 namespace와 동일해야 한다.(대소문자 주의할 것)
	private static String Namespace = "com.giggler.giggle.postUpload";

	@Override
	public int uploadPost(PostDTO postDTO) throws DataAccessException {
		
		return sqlSession.insert(Namespace + ".addPost", postDTO);
	}

	@Override
	public ListDTO postDetail(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".postDetail", post_no);
	}

}
