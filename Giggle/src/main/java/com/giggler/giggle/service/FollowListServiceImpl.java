package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.FollowListDAO;
import com.giggler.giggle.dto.FollowListDTO;

@Service
public class FollowListServiceImpl implements FollowListService {

	private static final Logger logger = LoggerFactory.getLogger(ListServiceImpl.class);
	
	@Inject
	private FollowListDAO followlistDAO;
	
	// 내가 팔로우한 사람 목록
	@Override
	public List<FollowListDTO> followingList(int user_no) throws Exception {
		logger.info("FollowListServiceImpl 내가 팔로우한 사람 목록");
		return followlistDAO.followingList(user_no);
	}

}
