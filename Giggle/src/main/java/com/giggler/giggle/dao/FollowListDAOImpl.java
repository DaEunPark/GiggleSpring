package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.FollowListDTO;

@Repository
public class FollowListDAOImpl implements FollowListDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ListDAOImpl.class);
	
	@Inject	
	private SqlSession sqlSession;
	private static String Namespace = "com.giggler.giggle.followList";
	
	// 내가 팔로우한 목록
	@Override
	public List<FollowListDTO> followingList(int user_no) throws Exception {
		return sqlSession.selectList(Namespace+".followingList", user_no);
	}

}