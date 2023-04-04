package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ListDTO;

@Repository
public class ListDAOImpl implements ListDAO {
	
private static final Logger logger = LoggerFactory.getLogger(ListDAOImpl.class);
	
	@Inject	
	private SqlSession sqlSession;
	private static String Namespace = "com.giggler.giggle.List";
	
	
	//메인 피드 목록
	@Override
	public List<ListDTO> allfeedList() throws Exception {
		logger.info("메인 피드 목록 DAO 지나감");
		
		List<ListDTO> allfeedList = sqlSession.selectList( Namespace + ".AllFeedList");
		return allfeedList;
	}//END - 메인 피드 목록

	//검색 피드 목록
	@Override
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception {
		logger.info("검색용 DAO 지나감");
		return  sqlSession.selectList( Namespace + ".selectsearchfeedList" ,listDTO);
	}//END - 검색 피드 목록

}// END - public class ListDAOImpl implements ListDAO
