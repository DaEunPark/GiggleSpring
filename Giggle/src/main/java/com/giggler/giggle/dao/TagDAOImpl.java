package com.giggler.giggle.dao;



import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.TrendDTO;


@Repository("TagDAO")
public class TagDAOImpl implements TagDAO {
	
	@Inject
	private SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(TagDAOImpl.class);
	
	private static final String Namespace = "com.giggler.giggle.tag";

	//----------------------------------------------------------------------------------//
	// 태그 삽입하기
	//----------------------------------------------------------------------------------//	
	@Override
	public int insertTag(String hashTag) throws Exception {
		
		logger.info("TagDAO에서 insertTag()실행...");
		
		return sqlSession.insert(Namespace+".insertTag", hashTag);
	}

	//----------------------------------------------------------------------------------//
	// 실시간 트렌드 가져오기
	//----------------------------------------------------------------------------------//
	@Override
	public TrendDTO getTrend() throws Exception {
		
		logger.info("TagDAO에서 getTrend()실행...");
		
		return sqlSession.selectOne(Namespace+".getTrend");
	}
	
	
	
}
