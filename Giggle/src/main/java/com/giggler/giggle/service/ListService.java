package com.giggler.giggle.service;

import java.util.List;

import com.giggler.giggle.dto.ListDTO;

public interface ListService {

	
	//메인 피드 목록 
	public List <ListDTO> allfeedList() throws Exception;
	
	
	
}//END - public interface ListService
