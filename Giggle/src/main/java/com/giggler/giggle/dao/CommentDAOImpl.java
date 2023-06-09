package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dto.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	@Inject
	private static String Namespace = "com.giggler.giggle.comment";
	
	// 게시글 번호에 해당하는 댓글 갯수 구하기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public int commentListCount(int post_no) throws Exception {
		System.out.println("CommentDAOImpl의 commentListCount() 구하기....");
			
		return sqlSession.selectOne(Namespace + ".commentCount", post_no);
	}

	// 게시글 번호에 해당하는 댓글 리스트 불러오기
	//-----------------------------------------------------------------------------------------------------------	

	@Override
	public List<CommentDTO> commentList(int post_no) throws Exception {
		System.out.println("CommentDAOImpl의 commentList() 구하기....");
			
		return sqlSession.selectList(Namespace + ".commentList", post_no);
	}

	// 게시글 번호에 해당하는 댓글 등록하기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public int commentRegister(CommentDTO commentDTO) throws Exception {
		System.out.println("CommentDAOImpl의 commentRegister() 구하기....");
			
		return sqlSession.insert(Namespace + ".commentRegister", commentDTO);
	}

	// 댓글 번호에 해당하는 댓글 삭제하기
	@Override
	public int commentDelete(int comment_no) throws Exception {
		// logger.info("CommentDAOImpl 댓글 번호에 해당하는 댓글 삭제하기() 시작");
		System.out.println("CommentDAOImpl 댓글 번호에 해당하는 댓글 삭제하기() 시작");	
		return sqlSession.delete(Namespace + ".commentDelete", comment_no);
	}


}
