package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;

public interface ListDAO {

	// 메인 피드 목록 
	public List<ListDTO> allfeedList(String user_no) throws Exception;
	//검색 피드 목록 - feed용 VUE 
	public List<ListDTO> searchfeedList(ListDTO listDTO) throws Exception;
	//검색 피드 목록 - user용 VUE 	
	public List<UserDTO> searchuserList(String keyword) throws Exception;
	//search - mypage / notmypage 알아내기
	public UserDTO Gouserpage(int user_no) throws Exception;
	//내가 쓴글 목록 VUE : user_no으로 알아내기
	public List<ListDTO> myfeedList(int user_no) throws Exception;
	//내가 좋아요한 글 목록 VUE		
	public List<ListDTO> mylikefeedList(int user_no) throws Exception;

}//END -public interface ListDAO 
