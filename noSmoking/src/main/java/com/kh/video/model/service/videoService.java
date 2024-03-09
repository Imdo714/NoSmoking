package com.kh.video.model.service;

import java.util.ArrayList;

import com.kh.common.vo.PageInfo;
import com.kh.video.model.vo.video;

public interface videoService {

	// 자료실 비디오 등록
	int videoUpload(String title, String srcAttributeValue, int userNo);
	
	// 자료실 리스트 갯수
	int selectVideoCount();
	
	// 자료실 리스트
	ArrayList<video> videoListAll(PageInfo pi);
	
	// 자료실 디테일뷰
	ArrayList<video> videoDetail(int videoNo);
	
}
