package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.ListDAO;
import com.giggler.giggle.dto.ListDTO;

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

	
	//검색 피드 목록
	@Override
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception {
		logger.info("검색용 서비스 지나감");
		return listDAO.searchfeedList(listDTO);
	}//END - 검색 피드 목록
	


}// END - public class ListServiceImpl implements ListService 
