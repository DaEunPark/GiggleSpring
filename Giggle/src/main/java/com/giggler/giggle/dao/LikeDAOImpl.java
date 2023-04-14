package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.CommentDTO;
import com.giggler.giggle.dto.FollowDTO;
import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.service.PostUploadServiceImpl;

@Repository("likeDAO")
public class LikeDAOImpl implements LikeDAO {
	private static final Logger logger = LoggerFactory.getLogger(LikeDAOImpl.class);
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하자 : xml의 namespace와 동일해야 한다.(대소문자 주의할 것)
	@Inject
	private static String Namespace = "com.giggler.giggle.like";


	@Override
	public int likeCount(LikeDTO likeDTO) throws DataAccessException {
		System.out.println("CommentDAOImpl의 commentListCount() 구하기....");
			
		return sqlSession.selectOne(Namespace + ".likeCount", likeDTO);
	}

	// 게시글 번호에 해당하는 댓글 리스트 불러오기
	//-----------------------------------------------------------------------------------------------------------	

	@Override
	public List<LikeDTO> likeList(int user_no) throws DataAccessException {
		System.out.println("CommentDAOImpl의 commentList() 구하기....");
			
		return sqlSession.selectList(Namespace + ".likeList", user_no);
	}

	
	
	
	 @Override
	 public int pushLike(LikeDTO likeDTO) throws DataAccessException {
		int result= sqlSession.insert(Namespace + ".pushLike", likeDTO);
		 
		 if(result == 1) {
		int like_cnt = sqlSession.update(Namespace + ".upLikeCnt", likeDTO.getPost_no());
		
		 }
	     return result;
		 
	 }

	    @Override
 public int unLike(LikeDTO likeDTO) throws DataAccessException {
	    	int result = sqlSession.delete(Namespace + ".unlike", likeDTO);
		 if(result == 1) {
			int like_cnt = sqlSession.update(Namespace + ".unLikeCnt", likeDTO.getPost_no());
		
		 }
	    	return result;
	    }

    @Override
	public int isLike(LikeDTO likeDTO) throws DataAccessException  {
    	return sqlSession.selectOne(Namespace+".isLike",likeDTO);
	    }

	


	
	
	
	

}
