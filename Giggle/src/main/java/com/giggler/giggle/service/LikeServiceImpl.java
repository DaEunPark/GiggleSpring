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

	//좋아요 데이터에 해당 데이터가 있는지 확인하기
	@Override
	public int likeCount(LikeDTO likeDTO) throws DataAccessException {
		System.out.println("LikeServiceImpl likeCount() 구하기....");
			
		return likeDAO.likeCount(likeDTO);

	}
	
	//=========게시글 번호에 해당하는 좋아요 등록===================================//
	@Override
	public int pushLike(LikeDTO likeDTO) throws DataAccessException {
		System.out.println("CommentServiceImpl pushLike() 처리....");
			
		return likeDAO.pushLike(likeDTO);
	} 
	
    
    @Override
    public  int unLike(LikeDTO likeDTO) throws DataAccessException {
    	System.out.println("CommentServiceImpl unLike() 처리....");
            return likeDAO.unLike(likeDTO);
    }




}
