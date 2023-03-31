package com.giggler.giggle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.MJDAO;
import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.UserDTO;

@Service("mjService")
public class MJService {
	
	@Inject
	MJDAO mjDAO;
	
	//이메일 중복 확인하기===========================================
	public int emailCheck(String user_email) throws Exception {
		System.out.println("MjService의 emailCheck()");
		
		return mjDAO.emailCheck(user_email);
	}
	
	//닉네임 중복 확인하기========================================================
	public int nickCheck(String user_nick) throws Exception {
		System.out.println("MjService의 nickCheck()");
		
		return mjDAO.nickCheck(user_nick);
	}		
	
	//회원 정보로 회원 등록하기====================================================
	public int userRegister(UserDTO userDTO) throws Exception {
		System.out.println("MjService의 회원가입 처리 시작");
		
		return mjDAO.userRegister(userDTO);
	}

	//이메일을 가지고 UserDTO 객체 가져오기==========================================
	public UserDTO getUserDTOByEmail(String email) throws Exception {
		System.out.println("MjService의 getUserDTOByEmail()");
		
		return mjDAO.getUserDTOByEmail(email);
	}
	
	//회원 번호에 해당하는 알람 리스트 가져오기======================================
	public List<AlarmDTO> getAlarmListByUserNo (int user_no) throws Exception {
		System.out.println("MjService의 getAlarmListByUserNo()");
		
		return mjDAO.getAlarmListByUserNo(user_no);
	}
}
