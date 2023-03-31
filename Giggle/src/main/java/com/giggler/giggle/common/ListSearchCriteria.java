package com.giggler.giggle.common;

public class ListSearchCriteria {

	//검색
	
	private String searchType;   //검색타입(c : 내용 , n :유저닉네임 )
	private String Keyword; 	 //검색 키워드
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return Keyword;
	}
	public void setKeyword(String keyword) {
		Keyword = keyword;
	}
	@Override
	public String toString() {
		return "ListSearchCriteria [searchType=" + searchType + ", Keyword=" + Keyword + "]";
	}
	
	
	
	
}//END - public class ListSearchCriteria 

