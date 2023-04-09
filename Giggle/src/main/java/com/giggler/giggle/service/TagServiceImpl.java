package com.giggler.giggle.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.TagDAO;
import com.giggler.giggle.dto.TrendDTO;


@Service("TagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	TagDAO tagDAO;
	
	Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

	
	//----------------------------------------------------------------------------------//
	// 태그 삽입하기
	//----------------------------------------------------------------------------------//
	@Override
	public int insertTag(String hashTag) throws Exception {
		
		logger.info("TagService에서 insertTag()실행...");
		
		return tagDAO.insertTag(hashTag);
	}


	//----------------------------------------------------------------------------------//
	// 실시간 트렌드 가져오기
	//----------------------------------------------------------------------------------//
	@Override
	public TrendDTO getTrend() throws Exception {

		logger.info("TagService에서 getTrend()실행...");
		
		return tagDAO.getTrend();
	}
	


}
