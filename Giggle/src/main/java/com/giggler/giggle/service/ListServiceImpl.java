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
	public List<ListDTO> allfeedList() throws Exception {
		logger.info("메인 피드 목록 서비스 지나감");
		return listDAO.allfeedList();
	}//END - 메인 피드 목록 

	
	//검색 피드 목록 - feed용 VUE 
	@Override
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception {
		logger.info("검색용 서비스 지나감 - feed용 VUE");
		return listDAO.searchfeedList(listDTO);
	}//END - 검색 피드 목록
	
//	//검색 피드 목록 - user용 VUE 	
//		@Override
//		public List<ListDTO> searchuserList(ListDTO listDTO) throws Exception {
//			logger.info("검색용 서비스 지나감- user용 VUE");
//			return listDAO.searchuserList(listDTO);
//		}//END - 검색 피드 목록
	
	//검색 피드 목록 - user용 VUE 	
	@Override
	public List<UserDTO> searchuserList(String keyword) throws Exception {
		System.out.println("검색용 서비스 지나감- user용 VUE");
		
		return listDAO.searchuserList(keyword);
	}//END - 검색 피드 목록


}// END - public class ListServiceImpl implements ListService 
