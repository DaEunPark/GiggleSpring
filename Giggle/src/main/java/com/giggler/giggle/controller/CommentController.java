package com.giggler.giggle.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.CommentDTO;
import com.giggler.giggle.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")

public class CommentController {
	@Inject
	CommentService commentService;
	@Autowired
	CommentDTO commentDTO;
	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 댓글 등록하기
	//-----------------------------------------------------------------------------------------------------------
		@ResponseBody
		@PostMapping("/commentRegister")
		// @RequestMapping(value = "/commentRegister", method = RequestMethod.POST)
		public int commentRegister(@RequestBody CommentDTO commentDTO,HttpServletRequest request) throws Exception {
			System.out.println("CommentController commentRegister() 시작");
			System.out.println("content= " + commentDTO);
			
			
	
		if(commentService.commentRegister(commentDTO) == 1) {
			
				return 3;
			} else {
			return 4;
		}
		
		}
		//------------------------------------------------------------------------------------*---------------------
		// 게시글에 해당하는 댓글 리스트 불러오기
		//-----------------------------------------------------------------------------------------------------------
		@GetMapping("/commentList/{post_no}")
		public List<CommentDTO> commentList(@PathVariable int post_no) throws Exception {
			System.out.println("CommentServiceImpl commentList() 구하기....");
				
		//	return commentDTO.commentList(post_no);
			List<CommentDTO> commentList = commentService.commentList(post_no);
			System.out.println(commentList);
			return commentList;
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 댓글 번호에 해당하는 댓글 삭제하기
		//-----------------------------------------------------------------------------------------------------------
		@ResponseBody
		@PostMapping("/commentDelete")
		//@RequestMapping(value = "/commentDelete", method = RequestMethod.POST)
		public String commentDelete(@RequestBody Map<String, String> info, HttpServletRequest request) throws Exception {
					
			System.out.println("댓글삭제 : " + request.getParameter("comment_no"));
			
			int comment_no = Integer.valueOf(info.get("comment_no"));
		
			System.out.println("CommentController 게시글 번호에 해당하는 댓글 삭제하기 번호: " + comment_no);
					
			if(commentService.commentDelete(comment_no) == 1) {
					return "Y";
				} else {
					return "N";
				}                              
		}
}
