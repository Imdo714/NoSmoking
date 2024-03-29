package com.kh.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.member.model.vo.Member;

@Repository
public class MemberDao {

	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public Member loginMember(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.loginMember", userId);
	}
	
	public int writerSearch(SqlSessionTemplate sqlSession, int userNo) {
		
		Integer result = sqlSession.selectOne("memberMapper.writerSearch", userNo);
	    return (result != null) ? 1 : 0;
	}
	
	public int insertWriter(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.insert("memberMapper.insertWriter", userNo);
	}
	
	public int smokingCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.smokingCount");
	}
	
	public int smokingInsert(SqlSessionTemplate sqlSession, Member m) {
		Integer result = sqlSession.selectOne("memberMapper.smokingInsert", m);
		return (result != null) ? 1 : 0;
	}
	
}
