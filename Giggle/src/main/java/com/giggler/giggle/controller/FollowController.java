package com.giggler.giggle.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.FollowDTO;
import com.giggler.giggle.service.FollowService;

@RestController("followController")
@CrossOrigin
public class FollowController {
	private static final Logger logger = LoggerFactory.getLogger(FollowController.class);
	
	@Inject
	private FollowService followService;
	
	@PostMapping("/follow")
	public String follow(@RequestBody FollowDTO followDTO) throws Exception {
		logger.info("FollowController follw() FollowDTO => " + followDTO);
		
		int result = followService.isFollowing(followDTO);		
		
		if (result == 0) {
			followService.follow(followDTO);
			return "Y";
		}			
		else {
			// 언팔 기능
			followService.unfollow(followDTO);
			return "N";
		}
	}
	
	@GetMapping("/followcheck")
	public String followCheck (@ModelAttribute FollowDTO followDTO) throws Exception {
		logger.info("FollowController followCheck() FollowDTO => " + followDTO);
		
		int result = followService.isFollowing(followDTO);		
		
		if (result == 1)
			return "Y";		
		else 
			return "N";
	}
}
