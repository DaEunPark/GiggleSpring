package com.giggler.giggle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.UserDTO;

@Repository("registerDAO")
public class MJDAO {

	@Inject
	private SqlSession sqlSession;
	private String Namespace = "com.giggler.giggle.mj";

	//이메일 중복 확인하기===========================================
	public int emailCheck(String user_email) throws Exception {
		System.out.println("MJDAO의 emailCheck()");
		
		return sqlSession.selectOne(Namespace + ".emailCheck" , user_email);
	}	
	
	//닉네임 중복 확인하기========================================================
	public int nickCheck(String user_nick) throws Exception {
		System.out.println("MJDAO의 nickCheck()");
		
		return sqlSession.selectOne(Namespace + ".nickCheck" , user_nick);
	}		
	
	//정보를 회원 테이블에 등록하기
	public int userRegister(UserDTO userDTO) throws Exception {
		System.out.println("MJDAO의 회원가입 처리 시작");
		
		return sqlSession.insert(Namespace + ".userRegister" , userDTO);
	}
	
	//이메일을 가지고 UserDTO 객체 가져오기
	public UserDTO getUserDTOByEmail(String email) throws Exception {
		System.out.println("MJDAO의 getUserDTOByEmail 시작");
		
		return sqlSession.selectOne(Namespace + ".getUserDTOByEmail", email);
	}
	
	//회원 번호에 해당하는 알람 리스트 가져오기
	public List<AlarmDTO> getAlarmListByUserNo (int user_no) throws Exception {
		System.out.println("MJDAO의 getAlarmListByUserNo 시작");
		
		return sqlSession.selectList(Namespace + ".getAlarmListByUserNo", user_no);
	}
}
