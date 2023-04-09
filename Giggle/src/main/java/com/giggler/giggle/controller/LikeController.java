package com.giggler.giggle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.ListDTO;
//import com.edu.board.controller.VueBoardController;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.dto.UserDTO;
import com.giggler.giggle.service.LikeService;
import com.giggler.giggle.service.PostUploadService;

@RestController("iLkeController")
@RequestMapping("/like")
@CrossOrigin
public class LikeController {

	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Inject
	private LikeService likeService;
	
	

	//좋아요 실험중======================================//

//	private Map<String, Object> heart(Model model, int user_no) throws Exception {
//		int user_no = Integer.parseInt(httpRequest.getParameter("like_no"));
//		User_no u = likeService.findByUser_no(user_no);
//		
// 		// 현재 로그인 유저가 좋아요를 눌렀는지 1 = 누름, 0 = 안누름
//		int like_no = heartService.countByPostIdAndUserId(user_no, u.getId());
//		// 이 게시물 자체의 좋아요 개수
//		int post_no = heartService.countByPost_no(post_no);
//		
//		// Map으로 만들어준다음 return
//		Map<String, Object> heartmap = new HashMap<String, Object>();
//		heartmap.put("like_cnt", like_cnt); // 헷갈리지 않게 이름은 똑같이..설정
//		heartmap.put("total_cnt", total_cnt);
//		
//		return heartmap;
//	}
//	
	 
	  @ResponseBody
	    @RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json")
	    public int like_no(HttpServletRequest httpRequest) throws Exception {

	        int like_no = Integer.parseInt(httpRequest.getParameter("like_no"));
	        int post_no = Integer.parseInt(httpRequest.getParameter("post_no"));
	        int user_no = Integer.parseInt(httpRequest.getParameter("user_no"));

	        PostDTO postDTO = new PostDTO();

	        postDTO.setPost_no(post_no);
	        postDTO.setUser_no(user_no);

	        System.out.println(like_no);

	        if(like_no >= 1) {
	        	likeService.deleteBoardLike(postDTO);
	            like_no=0;
	        } else {
	        	likeService.insertBoardLike(postDTO);
	            like_no=1;
	        }

	        return like_no;

	    }
	
	
}
