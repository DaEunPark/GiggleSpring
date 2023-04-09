package com.giggler.giggle.controller;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.giggler.giggle.dto.ListDTO;
//import com.edu.board.controller.VueBoardController;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.service.AwsS3Service;
import com.giggler.giggle.service.PostUploadService;

@RestController("postUploadController")
@RequestMapping("/post")
@CrossOrigin
public class PostUploadController {

	private static final Logger logger = LoggerFactory.getLogger(PostUploadController.class);
	
	@Inject
	private PostUploadService postUploadService;
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	private static final String CLOUD_FRONT_URL = "https://d36nj4zto99jeg.cloudfront.net/raw/";
	
	
	/*
	 * Vue에서 작성한 포스트를 받아서 DB에 저장
	 */
	@PostMapping("/uploadpost")
	public String uploadPost(@RequestBody PostDTO postDTO) throws Exception {
		logger.info("PostUploadController uploadPost() => " + postDTO);
		
		if(postUploadService.uploadPost(postDTO) == 1) {
			int currentPostNo = postUploadService.currentPostNo(postDTO);
			logger.info("PostUploadController currentPostNo => " + currentPostNo);
			
			return "Y";
		} else {
			return "N"; 
		}
		
	}
	
	/*
	 * Vue에서 포스트 상세 화면 표시 요청
	 */
	@GetMapping("/postdetail/{post_no}")
	public ListDTO postDetail(@PathVariable int post_no) throws Exception {
		logger.info("PostUploadController postDetail() post_no => " + post_no);
		
		return postUploadService.postDetail(post_no);
	}
	
	/*
	 * Vue에서 이미지 파일 받아오기
	 */
	@PostMapping("/uploadimage")
	public String uploadImage(@RequestParam MultipartFile files) throws IOException {
		logger.info("PostUploadController uploadImage() files => " + files.getOriginalFilename());
		boolean result = awsS3Service.uploadObject(files, files.getOriginalFilename());
		logger.info("PostUploadController uploadImage() result => " + result);
		return CLOUD_FRONT_URL + files.getOriginalFilename();
	}
	
}
