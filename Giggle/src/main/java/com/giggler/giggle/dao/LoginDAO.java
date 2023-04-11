package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.dto.UserDTO;

public interface LoginDAO {
	
	//----------------------------------------------------------------------------------//
	// 로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	public UserDTO userCheck(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 구글로그인 정보 가져오기(DB)
	//----------------------------------------------------------------------------------//
	public UserDTO googleUserCheck(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 아이디찾기
	//----------------------------------------------------------------------------------//
	public UserDTO searchId(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 비밀번호찾기
	//----------------------------------------------------------------------------------//
	public UserDTO searchPwd(UserDTO userDTO) throws Exception;

	//----------------------------------------------------------------------------------//
	// 프로필 사진 수정하기
	//----------------------------------------------------------------------------------//
	public int updatePic(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 프로필 정보 수정하기
	//----------------------------------------------------------------------------------//
	public int updateProfile(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 수정한 프로필 정보 가져오기
	//----------------------------------------------------------------------------------//
	public UserDTO updateCheck(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// mypage / notmypage알아내기
	//----------------------------------------------------------------------------------//
	public PostDTO whichProfile(int post_no) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 다른 사람 프로필 가져오기
	//----------------------------------------------------------------------------------//
	public UserDTO otherProfile(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// myPage 게시글 수, 팔로워 수, 팔로잉 수
	//----------------------------------------------------------------------------------//
	public UserDTO profileCnt(String user_no) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 프로필 사진 업데이트하기
	//----------------------------------------------------------------------------------//
	public int picUpdate(UserDTO userDTO) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(3명)
	//----------------------------------------------------------------------------------//
	public List<UserDTO> recommendFollow(String user_no) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 팔로우 추천(전부)
	//----------------------------------------------------------------------------------//
	public List<UserDTO> recommendFollowAll(String user_no) throws Exception;

}
