package com.giggler.giggle.dao;

import com.giggler.giggle.dto.TrendDTO;

public interface TagDAO {
	
	//----------------------------------------------------------------------------------//
	// 태그 삽입하기
	//----------------------------------------------------------------------------------//
	public int insertTag(String hashTag) throws Exception;
	
	//----------------------------------------------------------------------------------//
	// 실시간 트렌드 가져오기
	//----------------------------------------------------------------------------------//
	public TrendDTO getTrend() throws Exception;

}