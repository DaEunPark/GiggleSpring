package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.CommentDTO;
import com.giggler.giggle.dto.PostDTO;

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
			
		int result = sqlSession.insert(Namespace + ".commentRegister", commentDTO);
		if(result == 1) {
			//댓글 등록에 성공 하면 해당 게시글의 댓글 수를 1 증가시킨다.
			int imsi = sqlSession.update(Namespace + ".updateCommentCnt" , commentDTO.getPost_no());
			
			//게시글 작성자와 댓글 작성자가 같지 않을 경우 게시글 작성자 알람을 추가, 업데이트 한다.
			//게시글 번호로 게시글 정보를 가져온다.
			PostDTO postDTO = sqlSession.selectOne(Namespace + ".getPostDTO", commentDTO.getPost_no());
			
			//게시글 작성자의 번호와 댓글 작성자의 번호를 비교한다.
			if(postDTO.getUser_no() != commentDTO.getUser_no()) {
				int imsisi = sqlSession.insert(Namespace + ".insertAlarmCnt", commentDTO);
				int imsisisi = sqlSession.update(Namespace + ".updateAlarmYn", commentDTO);
			}
		}
		
		return result;
	}

	// 댓글 번호에 해당하는 댓글 삭제하기
	@Override
	public int commentDelete(CommentDTO commentDTO) throws Exception {
		// logger.info("CommentDAOImpl 댓글 번호에 해당하는 댓글 삭제하기() 시작");
		System.out.println("CommentDAOImpl 댓글 번호에 해당하는 댓글 삭제하기() 시작");	
		
		int result = sqlSession.delete(Namespace + ".commentDelete", commentDTO);
		System.out.println("result 1 = " + result);	
		if(result == 1) {
			
			System.out.println("result 2 = " + result);	
			System.out.println("commentDTO ==> " + commentDTO);	
			int cntminus = sqlSession.update(Namespace + ".deleteCommentCnt", commentDTO);
			System.out.println("cntminus 1 = " + cntminus);	
			
		}
		return result;
	}
	


}
