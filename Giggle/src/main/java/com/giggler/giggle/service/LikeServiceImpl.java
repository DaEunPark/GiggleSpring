package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.giggler.giggle.controller.PostUploadController;
import com.giggler.giggle.dao.LikeDAO;
import com.giggler.giggle.dao.PostUploadDAO;
import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.PostDTO;

@Service("LikeServiece")
public class LikeServiceImpl implements LikeService {
	
	private static final Logger logger = LoggerFactory.getLogger(LikeServiceImpl.class);
	
	@Inject
	private LikeDAO likeDAO;

	//게시글 번호에 해당하는 댓글 갯수 구하기
	@Override
	public int likeCount(int post_no) throws DataAccessException {
		System.out.println("CommentServiceImpl commentListCount() 구하기....");
			
		return likeDAO.likeCount(post_no);

	}
	
	
		
	//게시글 번호에 해당하는 댓글 리스트 불러오기
	@Override
	public List<LikeDTO> likeList(int post_no) throws DataAccessException {
		System.out.println("CommentServiceImpl commentList() 구하기....");
			
		return likeDAO.likeList(post_no);
	}
		

	
	//=========게시글 번호에 해당하는 좋아요 등록===================================//
	@Override
	public int pushLike(LikeDTO likeDTO) throws DataAccessException {
		System.out.println("CommentServiceImpl commentRegister() 구하기....");
			
		return likeDAO.pushLike(likeDTO);
	} 
	
	
	
	
//	@Override 
//	    public int pushLike(LikeDTO likeDTO) throws DataAccessException {
//		 return likeDAO.pushLike(likeDTO);
//		 
//	    }
//
//	    @Override
//	    public int liked(LikeDTO likeDTO) throws DataAccessException {
//	    	return likeDAO.liked(likeDTO);
//	    	
//	    }
	    
	    @Override
	    public  int unLike(LikeDTO likeDTO) throws DataAccessException {
	            return likeDAO.unLike(likeDTO);
	    }



}
