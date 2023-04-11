package com.giggler.giggle.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.FollowDAO;
import com.giggler.giggle.dto.FollowDTO;

@Service("followService")
public class FollowServiceImpl implements FollowService {
	
	private static final Logger logger = LoggerFactory.getLogger(FollowServiceImpl.class);
	
	@Inject
	private FollowDAO followDAO;

	@Override
	public int follow(FollowDTO followDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return followDAO.follow(followDTO);
	}

	@Override
	public int isFollowing(FollowDTO followDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return followDAO.isFollowing(followDTO);
	}

	@Override
	public int unfollow(FollowDTO followDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return followDAO.unfollow(followDTO);
	}

}
