package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.ListDAO;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;

@Service
public class ListServiceImpl implements ListService {
	
	private static final Logger logger = LoggerFactory.getLogger(ListServiceImpl.class);
	
	@Inject
	private ListDAO listDAO;
	
	//메인 피드 목록
			@Override
			public List<ListDTO> allfeedList(String user_no) throws Exception {
			logger.info("메인 피드 목록 서비스 지나감");
			return listDAO.allfeedList(user_no);
			}	

	
	//검색 피드 목록 - feed용 VUE 
			@Override
			public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception {
			logger.info("검색용 서비스 지나감 - feed용 VUE");
			return listDAO.searchfeedList(listDTO);
			}
	
	//검색 피드 목록 - user용 VUE 	
			@Override
			public List<UserDTO> searchuserList(String keyword) throws Exception {
			logger.info("검색용 서비스 지나감- user용 VUE");
			return listDAO.searchuserList(keyword);
			}

	//search - mypage / notmypage 알아내기
			@Override
			public UserDTO Gouserpage(int user_no) throws Exception {
			logger.info("search - mypage / notmypage 알아내기 서비스 지나감");
			return listDAO.Gouserpage(user_no);
			}
			
	//내가 쓴글 목록 VUE : user_no으로 알아내기
			@Override
			public List<ListDTO> myfeedList(int user_no) throws Exception {
			logger.info("내가 쓴글 목록 서비스 지나감 VUE ");
			return listDAO.myfeedList(user_no);
			}
			
	//내가 좋아요한 글 목록 VUE		
			@Override
			public List<ListDTO> mylikefeedList(int user_no) throws Exception {
				logger.info("내가 좋아요한 글 목록 서비스 지나감 VUE ");
				return listDAO.mylikefeedList(user_no);
			}
			
			
			
			

}// END - public class ListServiceImpl implements ListService 
