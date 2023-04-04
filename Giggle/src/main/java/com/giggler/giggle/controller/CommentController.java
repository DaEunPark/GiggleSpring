package com.giggler.giggle.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.CommentDTO;
import com.giggler.giggle.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")

public class CommentController {
	@Inject
	CommentService commentService;
	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 댓글 등록하기
	//-----------------------------------------------------------------------------------------------------------
		//@ResponseBody
		@PostMapping("/commentRegister")
		// @RequestMapping(value = "/commentRegister", method = RequestMethod.POST)
		public String commentRegister(@RequestBody CommentDTO commentDTO,HttpServletRequest request) throws Exception {
			System.out.println("CommentController commentRegister() 시작");
		
			if(commentService.commentRegister(commentDTO) == 1) {
				
				return "Y";
			} else {
				return "N";
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 댓글 번호에 해당하는 댓글 삭제하기
		//-----------------------------------------------------------------------------------------------------------
		//@ResponseBody
		@PostMapping("/commentDelete")
		//@RequestMapping(value = "/commentDelete", method = RequestMethod.POST)
		public String commentDelete(@RequestBody int comment_no, int post_no, HttpServletRequest request) throws Exception {
					
		
			System.out.println("CommentController 게시글 번호에 해당하는 댓글 삭제하기 번호: " + comment_no);
					
			if(commentService.commentDelete(comment_no) == 1) {
					return "Y";
				} else {
					return "N";
				}
		}
}
