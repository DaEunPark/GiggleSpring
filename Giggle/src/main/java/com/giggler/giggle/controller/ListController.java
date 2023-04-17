package com.giggler.giggle.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

//import com.giggler.giggle.common.ListSearchCriteria;
import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.service.ListService;

@Controller
@RequestMapping("/*")
public class ListController {

	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	
	@Inject
	private ListService listService;
	
	//메인 피드 목록 
		@RequestMapping(value="/allfeedList" , method = RequestMethod.GET)
		public void allfeedList(Model model, @PathVariable String user_no) throws Exception {
			
			logger.info("메인 피드 목록 컨트롤러 지나감");
			
			List<ListDTO> allfeedList = listService.allfeedList(user_no);
			logger.info("메인 피드 목록 ==> " + allfeedList );
			
		
			model.addAttribute("allfeedList",allfeedList);
			
			}//END - 메인 피드 목록 
	
	
	
}//END - public class ListController 
	
