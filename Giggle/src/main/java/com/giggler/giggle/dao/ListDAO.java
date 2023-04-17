package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;

public interface ListDAO {

	// 메인 피드 목록 
	public List<ListDTO> allfeedList() throws Exception;
	//검색 피드 목록 - feed용 VUE 
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception;
	//검색 피드 목록 - user용 VUE 	
//	public List<ListDTO> searchuserList(ListDTO listDTO) throws Exception;
	public List<UserDTO> searchuserList(String keyword) throws Exception;
}//END -public interface ListDAO 
