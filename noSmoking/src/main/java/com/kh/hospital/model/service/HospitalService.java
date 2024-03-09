package com.kh.hospital.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.vo.PageInfo;
import com.kh.hospital.model.dao.HospitalDao;
import com.kh.hospital.model.vo.Hospital;
import com.kh.hospital.model.vo.Reply;

@Service
public class HospitalService implements HospitalServiceImp{
	
	@Autowired
	private HospitalDao hDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int hospitalCount() {
		return hDao.hospitalCount(sqlSession);
	}

	@Override
	public ArrayList<Hospital> selectHospital(PageInfo pi) {
		return hDao.selectHospital(sqlSession, pi);
	}

	@Override
	public ArrayList<Hospital> selectSearch(String comment) {
		return hDao.selectSearch(sqlSession, comment);
	}

	@Override
	public ArrayList<Hospital> selectSearchCity(String comment) {
		return hDao.selectSearchCity(sqlSession, comment);
	}

	@Override
	public ArrayList<Hospital> selectSearchAddres(String comment) {
		return hDao.selectSearchAddres(sqlSession, comment);
	}

	@Override
	public ArrayList<Hospital> selectSearchPhone(String comment) {
		return hDao.selectSearchPhone(sqlSession, comment);
	}

	@Override
	public Hospital detailHospital(int hNo) {
		return hDao.detailHospital(sqlSession, hNo);
	}

	@Override
	public int insertReply(String comment, int hNo, int userNo) {
		return hDao.insertReply(sqlSession, comment, hNo, userNo);
	}

	@Override
	public int selectReplyCount(int hNo) {
		return hDao.selectReplyCount(sqlSession, hNo);
	}

	@Override
	public ArrayList<Reply> selectReplyList(PageInfo pi, int hNo) {
		return hDao.selectReplyList(sqlSession, pi, hNo);
	}

	@Override
	public int deleteReply(int replyNo) {
		return hDao.deleteReply(sqlSession, replyNo);
	}

	@Override
	public int updateReply(String content, int replyNo) {
		return hDao.updateReply(sqlSession, content, replyNo);
	} 

}
