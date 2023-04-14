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
		System.out.println("라d잌");
		System.out.println("content= " + likeDTO);
		
		int result = likeService.likeCount(likeDTO);
		
	if(result==0 ) {
	likeService.pushLike(likeDTO);
		return "Y";
	}	 else {
		// 언팔 기능
likeService.unLike(likeDTO);
		return "N";
	}
}


	@GetMapping("/likeList/{user_no}")
	public List<LikeDTO> likeList(@PathVariable int user_no) throws Exception {
		System.out.println("likeList 구하기....");
			
	//	return commentDTO.commentList(post_no);
		List<LikeDTO> likeList = likeService.likeList(user_no);
		System.out.println(likeList);
		return likeList;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 댓글 번호에 해당하는 댓글 삭제하기
	//-----------------------------------------------------------------------------------------------------------
/*	@ResponseBody
	@PostMapping("/likeDelete")
	//@RequestMapping(value = "/commentDelete", method = RequestMethod.POST)
	public String unlike(@RequestBody Map<String, String> info, HttpServletRequest request) throws Exception {
				
		System.out.println("댓글삭제 : " + request.getParameter("like_no"));
		
		int like_no = Integer.valueOf(info.get("like_no"));
	
		System.out.println("ㅋ: " + like_no);
				
		if(likeService.unLike(like_no) == 1) {
				return "Y";
			} else {
				return "N";
			}                   }
	*/
	
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
	
	@PostMapping("/isLike")
	public int isLike(@RequestBody LikeDTO likeDTO) throws Exception {
	   
	 
	 return likeService.isLike(likeDTO);
	}
	
	
	
}

