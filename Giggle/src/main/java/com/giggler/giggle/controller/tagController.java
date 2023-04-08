package com.giggler.giggle.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.TrendDTO;
import com.giggler.giggle.service.TagService;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class tagController {
	
	@Autowired
	TagService tagservice;
	@Autowired
	TrendDTO trendDTO;

	private final static Logger logger = LoggerFactory.getLogger(tagController.class);
	
	//----------------------------------------------------------------------------------//
	// 태그 삽입하기
	//----------------------------------------------------------------------------------//
	@PostMapping("/insertTag")
	@ResponseBody
	public void insertTag(@RequestBody Map<String, String> content) throws Exception {
		
		logger.info("tagController에서 insertTag() 실행 중...");
		logger.info("content = " + content.get("text_content"));
		
		String text_content = content.get("text_content");
		String[] tag = text_content.split(" ");
		String[] tempHashTag = new String[1];
		
		for(int i=0; i<tag.length; i++) {
			if(!tag[i].contains("#")) {
				return;
			} else {
				tempHashTag[0] = tag[i].substring(0);
				
				if(tempHashTag[0].length() >8 
					||tempHashTag[0].length() <3 
					|| tempHashTag[0].matches(".*[~!@\\$%^&*\\(\\)\\-=+_'\\;<>0-9\\/\\.\\`:\\\"\\\\,\\[\\]?|{}\\s].*")
					|| tempHashTag[0].matches(".*[ㄱ-ㅎㅏ-ㅣ].*") ) {
						System.out.println("*****************************************");
						System.out.println("tag실패");
						System.out.println("*****************************************");
						return;			
					} else {
						String hashTag = tempHashTag[0];
						tagservice.insertTag(hashTag);			
						System.out.println("*****************************************");
						System.out.println("hashTag = " + hashTag);
						System.out.println("*****************************************");
				}
			}
			
		}
		

		
	}
	
	//----------------------------------------------------------------------------------//
	// 실시간 트렌드 가져오기
	//----------------------------------------------------------------------------------//
	@PostMapping("/trend")
	@ResponseBody
	public TrendDTO getTrend() throws Exception {
		
		logger.info("tagController에서 getTrend()실행...");
		
		TrendDTO trendDTO = tagservice.getTrend();
		
		System.out.println("*******************************************");
		System.out.println("trendDTO = "+trendDTO);
		System.out.println("*******************************************");
		
		return trendDTO;
	}

	
} // End - public class LoginController











