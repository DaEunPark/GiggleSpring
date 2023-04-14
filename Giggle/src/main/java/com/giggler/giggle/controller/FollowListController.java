package com.giggler.giggle.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.FollowListDTO;
import com.giggler.giggle.service.FollowListService;

@CrossOrigin
@RestController
public class FollowListController {
	private static final Logger logger = LoggerFactory.getLogger(FollowListController.class);
	
	@Inject
	private FollowListService followlistService;
	
	// 내가 팔로우한 유저 목록
	@GetMapping("/followingList/{user_no}")
	public List<FollowListDTO> followingList(@PathVariable int user_no) throws Exception{
		
		logger.info("FollowListController에서 following()실행...");
		List<FollowListDTO> followingList = followlistService.followingList(user_no);
		return followingList;
	}
}
