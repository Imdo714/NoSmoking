package com.kh.hospital.model.service;

import java.util.ArrayList;

import com.kh.common.vo.PageInfo;
import com.kh.hospital.model.vo.Hospital;
import com.kh.hospital.model.vo.Reply;

public interface HospitalServiceImp {
	
	// 보건소 갯수 
	int hospitalCount();
	
	// 보건소 리스트 가져오기
	ArrayList<Hospital> selectHospital(PageInfo pi);
	
	// 검색한 기관명 보건소 찾기
	ArrayList<Hospital> selectSearch(String comment);
	
	// 검색한 지역 보건소 찾기
	ArrayList<Hospital> selectSearchCity(String comment);
	
	// 검색한 주소 보건소 찾기
	ArrayList<Hospital> selectSearchAddres(String comment);
	
	// 검색한 전화번호 보건소 찾기
	ArrayList<Hospital> selectSearchPhone(String comment);
	
	// 병원 디테일
	Hospital detailHospital(int hNo);
	
	// 댓글 등록
	int insertReply(String comment, int hNo, int userNo);
	
	// 댓글 갯수
	int selectReplyCount(int hNo);
	
	// 댓글 페이징
	ArrayList<Reply> selectReplyList(PageInfo pi, int hNo);
	
	// 댓글 삭제 
	int deleteReply(int replyNo);
	
	// 댓글 업데이트
	int updateReply(String content, int replyNo);
	
}
