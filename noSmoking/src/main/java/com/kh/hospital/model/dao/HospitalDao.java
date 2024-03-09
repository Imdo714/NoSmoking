package com.kh.hospital.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.common.vo.PageInfo;
import com.kh.hospital.model.vo.Hospital;
import com.kh.hospital.model.vo.Reply;

@Repository
public class HospitalDao {
	
	
	public int hospitalCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("hospitalMapper.hospitalCount");
	}
	
	public ArrayList<Hospital> selectHospital(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectHospital", null, rowBounds);
	}
	
	public ArrayList<Hospital> selectSearch(SqlSessionTemplate sqlSession, String comment) {
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectSearch", comment);
	}
	
	public ArrayList<Hospital> selectSearchCity(SqlSessionTemplate sqlSession, String comment) {
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectSearchCity", comment);
	}
	
	public ArrayList<Hospital> selectSearchAddres(SqlSessionTemplate sqlSession, String comment) {
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectSearchAddres", comment);
	}
	
	public ArrayList<Hospital> selectSearchPhone(SqlSessionTemplate sqlSession, String comment) {
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectSearchPhone", comment);
	}
	
	public Hospital detailHospital(SqlSessionTemplate sqlSession, int hNo) {
		return sqlSession.selectOne("hospitalMapper.detailHospital", hNo);
	}
	
	public int insertReply(SqlSessionTemplate sqlSession, String comment, int hNo, int userNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comment", comment);
		params.put("hNo", hNo);
		params.put("userNo", userNo);
		
		return sqlSession.insert("hospitalMapper.insertReply", params);
	}
	
	public int selectReplyCount(SqlSessionTemplate sqlSession, int hNo) {
		return sqlSession.selectOne("hospitalMapper.selectReplyCount", hNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSessionTemplate sqlSession, PageInfo pi, int hNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("hospitalMapper.selectReplyList", hNo, rowBounds);
	}
	
	public int deleteReply(SqlSessionTemplate sqlSession, int replyNo) {
	    return sqlSession.delete("hospitalMapper.deleteReply", replyNo);
	}
	
	public int updateReply(SqlSessionTemplate sqlSession, String content, int replyNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", content);
		params.put("replyNo", replyNo);
		System.out.println(params);
		
	    return sqlSession.update("hospitalMapper.updateReply", params);
	}

}
