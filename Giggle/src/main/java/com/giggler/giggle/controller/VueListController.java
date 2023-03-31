package com.giggler.giggle.controller;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.service.ListService;

@CrossOrigin
@RestController
public class VueListController {
	private static final Logger logger = LoggerFactory.getLogger(VueListController.class);

	@Inject
	private ListService listService;
	
	//메인 피드 목록 VUE 
		@GetMapping("/main/mainhome")
		public List<ListDTO> allfeedList() throws Exception {
			
			List<ListDTO> allfeedList = listService.allfeedList();
			return allfeedList;
		}
		
	}// END - public class VueListController


