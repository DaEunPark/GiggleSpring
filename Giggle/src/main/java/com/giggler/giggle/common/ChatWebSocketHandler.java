package com.giggler.giggle.common;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.springframework.web.socket.CloseStatus;

import org.springframework.web.socket.TextMessage;

import org.springframework.web.socket.WebSocketSession;

import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.giggler.giggle.dao.ChatDAO;
import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageVO;
import com.giggler.giggle.dto.UserDTO;

import com.google.gson.Gson;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	@Inject
	private ChatDAO dao;

	private List<WebSocketSession> connectedUsers;

	public ChatWebSocketHandler() {
	    connectedUsers = new ArrayList<WebSocketSession>();
	}

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log(session.getId() + " 연결 됨!!");
		users.put(session.getId(), session);
		connectedUsers.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료됨");
		connectedUsers.remove(session);
		users.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		Map<String, Object> map = null;

	    MessageVO messageVO = MessageVO.convertMessage(message.getPayload());
	    System.out.println("1 : " + messageVO.toString());


	    ChatRoomDTO roomVO  = new ChatRoomDTO();
	    roomVO.setUSER_user_nick(messageVO.getUSER_user_nick()); //유저

	    ChatRoomDTO croom =null;
	    if(messageVO.getUSER_user_nick().equals(messageVO.getUSER_user_nick())) {
	    	System.out.println("a");
	    	  	if(dao.isRoom(roomVO) == null ) {
	    	  		System.out.println("b");
	    	  		dao.createRoom(roomVO);
	    	  		System.out.println("d");
	    	  		croom = dao.isRoom(roomVO);
	    	  	} else {
	    	  		System.out.println("C");
	    	  		croom = dao.isRoom(roomVO);
	    	  	}
	      	} else {
	      		croom = dao.isRoom(roomVO);
	      	}

	      	messageVO.setCHATROOM_chatroom_no(croom.getChatroom_no());
	      	if(croom.getUSER_user_nick().equals(messageVO.getMessage_sender())) {
	      		messageVO.setMessage_reciver(roomVO.getUSER_user_nick());
	      	}

	      	for (WebSocketSession websocketSession : connectedUsers) {
	      		map = websocketSession.getAttributes();
	      		UserDTO login = (UserDTO) map.get("login");

		        //받는사람
		        if (login.getUser_nick().equals(messageVO.getMessage_sender())) {
		        	Gson gson = new Gson();
		            String msgJson = gson.toJson(messageVO);
		            websocketSession.sendMessage(new TextMessage(msgJson));
		        }
	      	}
	   	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId() + " 익셉션 발생: " + exception.getMessage());
	}

	private void log(String logmsg) {System.out.println(new Date() + " : " + logmsg);}

}