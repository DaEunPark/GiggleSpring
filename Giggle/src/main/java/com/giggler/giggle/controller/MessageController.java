package com.giggler.giggle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giggler.giggle.dao.MessageDAO;
import com.giggler.giggle.dto.MessageDTO;

@Controller
public class MessageController {

	@Autowired
	private MessageDAO messageDAO;
	
	// 메세지 목록
	@RequestMapping(value = "/message_list.do")
	public String messageList(HttpServletRequest request, HttpSession session) {
		System.out.println("현재 사용자 닉네임 : " + session.getAttribute("user_nick"));
		
		String nick = (String) session.getAttribute("user_nick");
		
		MessageDTO dto = new MessageDTO();
		dto.setUser_nick(nick);
		
		// 메세지 리스트
		ArrayList<MessageDTO> list = messageDAO.messageList(dto);
		
		request.setAttribute("list", list);
		
		return "message/message_ajax_list";
	}
}
