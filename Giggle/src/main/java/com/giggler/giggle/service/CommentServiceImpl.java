package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.CommentDAO;
import com.giggler.giggle.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

@Inject
private CommentDAO commentDAO;

//게시글 번호에 해당하는 댓글 갯수 구하기
@Override
public int commentListCount(int post_no) throws Exception {
	System.out.println("CommentServiceImpl commentListCount() 구하기....");
		
	return commentDAO.commentListCount(post_no);
}
	
	
//게시글 번호에 해당하는 댓글 리스트 불러오기
@Override
public List<CommentDTO> commentList(int post_no) throws Exception {
	System.out.println("CommentServiceImpl commentList() 구하기....");
		
	return commentDAO.commentList(post_no);
}
	

//게시글 번호에 해당하는 댓글 등록하기
@Override
public int commentRegister(CommentDTO commentDTO) throws Exception {
	System.out.println("CommentServiceImpl commentRegister() 구하기....");
		
	return commentDAO.commentRegister(commentDTO);
}

	
//게시글 번호에 해당하는 댓글 삭제하기
@Override
public int commentDelete(CommentDTO commentDTO) throws Exception {

	System.out.println ("CommentServiceImpl 댓글 번호에 해당하는 댓글 삭제하기() 시작");
	return commentDAO.commentDelete(commentDTO);
}
}
