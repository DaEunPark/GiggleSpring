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

@Repository("LikeDAO")
public class LikeDAOImpl implements LikeDAO {
	private static final Logger logger = LoggerFactory.getLogger(LikeDAOImpl.class);
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하자 : xml의 namespace와 동일해야 한다.(대소문자 주의할 것)
	private static String Namespace = "com.giggler.giggle.like";


	 @Override
	    public int getBoardLike(PostDTO postDTO) throws DataAccessException {
	        return sqlSession.selectOne(Namespace+".getBoardLike",postDTO);
	    }

	    @Override
	    public void insertBoardLike(PostDTO postDTO) throws DataAccessException {
	    	sqlSession.insert(Namespace+".createBoardLike",postDTO);
	    }

	    @Override
	    public void deleteBoardLike(PostDTO postDTO) throws DataAccessException {
	    	sqlSession.delete(Namespace+".deleteBoardLike",postDTO);
	    }

	    @Override
	    public void updateBoardLike(int post_no) throws DataAccessException {
	    	sqlSession.update(Namespace+".updateBoardLike",post_no);
	    }

	
	
	
	

}
