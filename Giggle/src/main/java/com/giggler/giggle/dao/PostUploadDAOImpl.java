package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ImageDTO;
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

	@Override
	public int currentPostNo(PostDTO postDTO) throws DataAccessException {
		int current = sqlSession.selectOne(Namespace + ".currentPost", postDTO);
		return current;
	}

	@Override
	public int uploadImage(ImageDTO imageDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace + ".uploadImage", imageDTO);
	}

	@Override
	public List<ImageDTO> postImages(ImageDTO imageDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".postImages", imageDTO);
	}

	@Override
	public int deletePostImages(ImageDTO imageDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace + ".deletePostImages", imageDTO);
	}

	@Override
	public int deletePost(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace + ".deletePost", post_no);
	}

	@Override
	public int deleteImage(String imagepath) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace + ".deleteImage", imagepath);
	}

	@Override
	public int updatePost(PostDTO postDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace + ".updatePost", postDTO);
	}

	@Override
	public int beforeDeleteImage(String imagepath) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace + ".beforeDeleteImage", imagepath);
	}

	@Override
	public int cancelUpdate(int post_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace + ".cancelDeleteImage", post_no);
	}

}
