package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;

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

	//검색 피드 목록 - feed용 VUE 
			@Override
			public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception {
			logger.info("검색용 DAO 지나감- feed용 VUE");
			return  sqlSession.selectList( Namespace + ".selectsearchfeedList" ,listDTO);
			}//END - 검색 피드 목록
	
	//검색 피드 목록 - user용 VUE 	
			@Override
			public List<UserDTO> searchuserList(String keyword) throws Exception {
			logger.info("검색용 DAO 지나감- user용 VUE");
			
			return sqlSession.selectList(Namespace + ".selectsearchuserList", keyword);		
			}//END - 검색 피드 목록

	//search - mypage / notmypage 알아내기
			@Override
			public UserDTO Gouserpage(int user_no) throws Exception {
			logger.info("search - mypage / notmypage 알아내기 DAO 지나감");
			
			return sqlSession.selectOne(Namespace + ".Gouserpage", user_no);		
			}
	//내가 쓴글 목록 VUE : user_no으로 알아내기
			@Override
			public List<ListDTO> myfeedList(int user_no) throws Exception {
				
				return sqlSession.selectList( Namespace + ".MyFeedlist" , user_no);
				 
			}
	//내가 좋아요한 글 목록 VUE		
			@Override
			public List<ListDTO> mylikefeedList(int user_no) throws Exception {
				
				return sqlSession.selectList( Namespace + ".MyLikeFeedlist" , user_no);
			}
					
			
			
}// END - public class ListDAOImpl implements ListDAO
