package com.giggler.giggle.controller;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
		@GetMapping("/main/mainhome/{user_no}")
		public List<ListDTO> allfeedList(@PathVariable String user_no) throws Exception {
			
			logger.info("allfeedList에서 user_no = " + user_no);
			
			System.out.println("user_no = " + user_no);
			
			List<ListDTO> allfeedList = listService.allfeedList(user_no);
			return allfeedList;
			}
		
		//검색 피드 목록 - feed용 VUE 
		@GetMapping("/main/search/{keyword}/userno/{user_no}")
		public List<ListDTO> searchfeedList(@PathVariable(value="keyword", required=false) String keyword, @PathVariable String user_no, Model model) throws Exception {
			
			logger.info("검색 피드 목록 - feed용 VUE");
			
			ListDTO listDTO = new ListDTO();
			model.addAttribute("keyword", keyword);
			listDTO.setKeyword(keyword);
			listDTO.setUser_no(Integer.valueOf(user_no));
			
			System.out.println("listDTO.getKeyword() = " + listDTO.getKeyword());
			System.out.println("listDTO.getUser_no() = " + listDTO.getUser_no());
			return listService.searchfeedList(listDTO);
			}		
		
	//검색 피드 목록 - user용 VUE 	-- post로 변경
		@PostMapping("/main/searchuser/{keyword}")
		public List<UserDTO> searchuserList(@PathVariable String keyword) throws Exception {
			logger.info("검색 피드 목록 - user용 VUE" + keyword);
			
			return listService.searchuserList(keyword);
			}
		
		
	//search - MyPage / NotMyPage 알아내기
		@PostMapping("/Gouserpage")
		public UserDTO Gouserpage(@RequestBody Map<String, String> param) throws Exception {
			
			logger.info("ListController에서 Gouserpage()실행....");
			logger.info("user_no = " + param.get("user_no"));
			
			int user_no = Integer.valueOf(param.get("user_no"));
			UserDTO UserDTO = listService.Gouserpage(user_no);
			return UserDTO;
			}
		
		
	//내가 쓴글 목록 VUE : user_no으로 알아내기
		@PostMapping("/myfeedList/{user_no}")
		public List<ListDTO> myfeedList(@PathVariable int user_no) throws Exception {
			
			logger.info("ListController에서 myfeedList()실행....");
			List<ListDTO> myfeedList = listService.myfeedList(user_no);
			return myfeedList;
			}
	
	//내가 좋아요한 글 목록 VUE
		@PostMapping("/mylikefeedList/{user_no}")
		public List<ListDTO> mylikefeedList(@PathVariable int user_no) throws Exception {
			
			logger.info("ListController에서 mylikefeedList()실행....");
			List<ListDTO> mylikefeedList = listService.mylikefeedList(user_no);
			return mylikefeedList;
			}
		
		
		
	}// END - public class VueListController


