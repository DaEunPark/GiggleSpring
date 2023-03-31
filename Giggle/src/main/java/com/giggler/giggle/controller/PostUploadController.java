package com.giggler.giggle.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.edu.board.controller.VueBoardController;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.service.PostUploadService;

@RestController("postUploadController")
@RequestMapping("/post")
@CrossOrigin("http://localhost:8080")
public class PostUploadController {

	private static final Logger logger = LoggerFactory.getLogger(PostUploadController.class);
	
	@Inject
	private PostUploadService postUploadService;
	
	
	/*
	 * Vue에서 작성한 포스트를 받아서 DB에 저장
	 */
	@PostMapping("/uploadpost")
	public String uploadPost(@RequestBody PostDTO postDTO) throws Exception {
		logger.info("PostUploadController uploadPost() => " + postDTO);
		
		if(postUploadService.uploadPost(postDTO) == 1) {
			return "Y";
		} else {
			return "N"; 
		}
		
	}
	
}
