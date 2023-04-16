package com.giggler.giggle.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		List<FollowListDTO> followingList = followlistService.followingList(user_no);
		logger.info("followingList = " + followingList);		
		
		return followingList;
	}
	

	// 나를 팔로우한 유저 목록
	@GetMapping("/followerList/{user_no}")
	public List<FollowListDTO> followerList(@PathVariable int user_no) throws Exception{
		
		logger.info("FollowListController에서 follower()실행...");
		List<FollowListDTO> followerList = followlistService.followerList(user_no);
		return followerList;
	}

	@PostMapping("/followingList")
	public List<FollowListDTO> followingList(@RequestBody Map<String, String> userInfo) throws Exception{
		
		logger.info("FollowListController에서 followingList()실행...");
		int user_no = Integer.valueOf(userInfo.get("user_no"));
		logger.info("user_no = " + user_no);
		
		List<FollowListDTO> followerList = followlistService.followerList(user_no);
		logger.info("followerList = " + followerList);
		
		
		return followerList;
	}
	
	// 내가 블락한 유저 목록
	@PostMapping("/blockList")
	public List<FollowListDTO> blockList(@RequestBody Map<String, String> userInfo) throws Exception{
		
		logger.info("FollowListController에서 blockList()실행...");
		int user_no = Integer.valueOf(userInfo.get("user_no"));
		logger.info("user_no = " + user_no);
		
		List<FollowListDTO> blockList = followlistService.blockList(user_no);
		logger.info("blockList = " + blockList);
		
		
		return blockList;
	}

}
