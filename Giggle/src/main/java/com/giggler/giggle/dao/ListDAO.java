package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.ListDTO;

public interface ListDAO {

	// 메인 피드 목록 
	public List<ListDTO> allfeedList() throws Exception;
	//검색 피드 목록
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception;
	
}//END -public interface ListDAO 
