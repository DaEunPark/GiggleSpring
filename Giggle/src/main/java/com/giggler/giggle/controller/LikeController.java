package com.giggler.giggle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.CommentDTO;
import com.giggler.giggle.dto.FollowDTO;
import com.giggler.giggle.dto.LikeDTO;
import com.giggler.giggle.service.LikeService;


@RestController("likeController")
@CrossOrigin
public class LikeController {

	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Inject
	LikeService likeService;
	
	@Autowired
	LikeDTO likeDTO;
	
	@ResponseBody
	@PostMapping("/pushLike")
	public String pushLike(@RequestBody LikeDTO likeDTO, HttpServletRequest request) throws Exception {
		System.out.println("LikeController 좋아요 누름: " + likeDTO);
		
		int result = likeService.likeCount(likeDTO);
		
		if(result == 0 ) {
			System.out.println("좋아요 데이터 추가");
			likeService.pushLike(likeDTO);
			return "Y";
		} else {
			// 좋아요 취소
			System.out.println("좋아요 데이터 삭제");
			likeService.unLike(likeDTO);
			return "N";
		}
	}


	@GetMapping("/likeCount")
	public String likeCount (@ModelAttribute LikeDTO likeDTO) throws Exception {
		logger.info("likeCount => " + likeDTO);
		
		int result = likeService.likeCount(likeDTO);		
		
		if (result == 1) {
			return "Y";		
		}else {
			return "N";
	}
} 
}

