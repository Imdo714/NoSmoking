package com.kh.video.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.vo.PageInfo;
import com.kh.video.model.dao.videoDao;
import com.kh.video.model.vo.video;

@Service
public class videoServiceImpl implements videoService{

	@Autowired
	public videoDao vDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	@Override
	public int videoUpload(String title, String srcAttributeValue, int userNo) {
		return vDao.videoUpload(sqlSession, title, srcAttributeValue, userNo);
	}

	@Override
	public int selectVideoCount() {
		return vDao.selectVideoCount(sqlSession);
	}

	@Override
	public ArrayList<video> videoListAll(PageInfo pi) {
		return vDao.videoListAll(sqlSession, pi);
	}

	@Override
	public ArrayList<video> videoDetail(int videoNo) {
		return vDao.videoDetail(sqlSession, videoNo);
	}

	
}
