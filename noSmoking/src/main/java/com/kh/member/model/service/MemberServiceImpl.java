package com.kh.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession; 

	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(sqlSession, m);
	}

	@Override
	public Member loginMember(String userId) {
		return memberDao.loginMember(sqlSession, userId);
	}
	
	@Override
	public int writerSearch(int userNo) {
		return memberDao.writerSearch(sqlSession, userNo);
	}

	@Override
	public int insertWriter(int userNo) {
		return memberDao.insertWriter(sqlSession, userNo);
	}

	@Override
	public int smokingCount() {
		return memberDao.smokingCount(sqlSession);
	}

	@Override
	public int smokingInsert(Member m) {
		return memberDao.smokingInsert(sqlSession, m);
	}

	

}
