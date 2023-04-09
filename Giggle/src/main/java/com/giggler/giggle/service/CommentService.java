package com.giggler.giggle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.giggler.giggle.dto.CommentDTO;


public interface CommentService {

	// 게시글 번호에 해당하는 댓글 수 구하기
	public int commentListCount(int post_no) throws Exception;
			

	// 게시글 번호에 해당하는 댓글 리스트 가져오기
	public List<CommentDTO> commentList(int post_no) throws Exception;
			

	// 댓글 등록 처리하기
	public int commentRegister(CommentDTO commentDTO) throws Exception;	
			

	// 댓글 번호에 해당하는 댓글 삭제하기
	public int commentDelete(int comment_no) throws Exception;		
			

	
}
