package com.giggler.giggle.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.FollowDTO;

@Repository("followDAO")
public class FollowDAOImpl implements FollowDAO {
private static final Logger logger = LoggerFactory.getLogger(FollowDAOImpl.class);
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하자 : xml의 namespace와 동일해야 한다.(대소문자 주의할 것)
	private static String Namespace = "com.giggler.giggle.follow";

	@Override
	public int follow(FollowDTO followDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		int following = sqlSession.insert(Namespace + ".addfollowing", followDTO);
		int follower = sqlSession.insert(Namespace + ".addfollower", followDTO);
		return following + follower;
	}

	@Override
	public int isFollowing(FollowDTO followDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".isFollowing", followDTO);
	}

	@Override
	public int unfollow(FollowDTO followDTO) throws DataAccessException {
		int following = sqlSession.delete(Namespace + ".deletefollowing", followDTO);
		int follower = sqlSession.delete(Namespace + ".deletefollower", followDTO);
		return following + follower;
	}

}
