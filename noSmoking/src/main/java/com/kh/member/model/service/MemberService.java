package com.kh.member.model.service;

import com.kh.member.model.vo.Member;

public interface MemberService {

	// 회원가입
	int insertMember(Member m);
	
	// 로그인
	Member loginMember(String userId);
	
	// 금연신청 했는지 조회
	int writerSearch(int userNo);
	
	// 금연신청 
	int insertWriter(int userNo);
	
	// 신청자 몇명
	int smokingCount();
	
	// 
	int smokingInsert(Member m);
}
