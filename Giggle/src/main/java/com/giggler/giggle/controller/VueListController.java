package com.giggler.giggle.controller;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;
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
		
	//검색 피드 목록 - feed용 VUE 
		@GetMapping("/main/search/{keyword}")
		public List<ListDTO> searchfeedList(@PathVariable(value="keyword", required=false) String keyword, Model model) throws Exception {
			
			System.out.println("검색 피드 목록 - feed용 VUE");
			
			ListDTO listDTO = new ListDTO();
			model.addAttribute("keyword", keyword);
			listDTO.setKeyword(keyword);
			return listService.searchfeedList(listDTO);
		}
		
	//검색 피드 목록 - user용 VUE 	
//		@GetMapping("/main/searchuser/{keyword}")
//		public List<ListDTO> searchuserList(@PathVariable(value="keyword", required=false) String keyword, Model model) throws Exception {
//			
//			System.out.println("검색 피드 목록 - user용 VUE ");
//			
//			ListDTO listDTO = new ListDTO();
//			model.addAttribute("keyword", keyword);
//			listDTO.setKeyword(keyword);
//			return listService.searchuserList(listDTO);
//		}
		
		//검색 피드 목록 - user용 VUE 	
		@GetMapping("/main/searchuser/{keyword}")
		public List<UserDTO> searchuserList(@PathVariable String keyword) throws Exception {
			System.out.println("검색 피드 목록 - user용 VUE" + keyword);
			
			return listService.searchuserList(keyword);
		}
		
	//내가 쓴글 목록 VUE
		
		
	}// END - public class VueListController


