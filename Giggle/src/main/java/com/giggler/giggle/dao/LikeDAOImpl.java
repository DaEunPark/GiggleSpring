package com.giggler.giggle.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.dto.PostDTO;

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
		System.out.println("LikeDAOImpl의 likeCount() 구하기....");
			
		return sqlSession.selectOne(Namespace + ".likeCount", likeDTO);
	}

	
	 @Override
	 public int pushLike(LikeDTO likeDTO) throws DataAccessException {
		 System.out.println("LikeDAOImpl의 pushLike() 처리하기....");
		 
		int result= sqlSession.insert(Namespace + ".pushLike", likeDTO);
		 
		 if(result == 1) {
			 int like_cnt = sqlSession.update(Namespace + ".upLikeCnt", likeDTO.getPost_no());
			 
			 //내가 쓴 게시글이 아니면 게시글 작성자에게 알람을 추가해준다.
			//게시글 번호로 게시글 정보를 가져온다.
			PostDTO postDTO = sqlSession.selectOne(Namespace + ".getPostDTO", likeDTO.getPost_no());
			
			//게시글 작성자의 번호와 댓글 작성자의 번호를 비교한다.
			if(postDTO.getUser_no() != likeDTO.getUser_no()) {
				int imsisi = sqlSession.insert(Namespace + ".insertAlarmCnt", likeDTO);
				int imsisisi = sqlSession.update(Namespace + ".updateAlarmYn", likeDTO);
			}
		
		 }
	     return result;
		 
	 }

    @Override
    public int unLike(LikeDTO likeDTO) throws DataAccessException {
    	System.out.println("LikeDAOImpl의 unLike() 처리하기....");
    	
    	int result = sqlSession.delete(Namespace + ".unLike", likeDTO);
    	
		 if(result == 1) {
			int like_cnt = sqlSession.update(Namespace + ".unLikeCnt", likeDTO);
		
		 }
    	return result;
    }

	
	
	
	

}
