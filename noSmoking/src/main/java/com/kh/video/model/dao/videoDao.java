package com.kh.video.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.common.vo.PageInfo;
import com.kh.product.model.vo.Product;
import com.kh.video.model.vo.video;

@Repository
public class videoDao {

	// 자료실 비디오 등록
	public int videoUpload(SqlSessionTemplate sqlSession, String title, String srcAttributeValue, int userNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title", title);
		params.put("srcAttributeValue", srcAttributeValue);
		params.put("userNo", userNo);
		
		return sqlSession.insert("videoMapper.videoUpload", params);
	}
	
	// 자료실 리스트 갯수
	public int selectVideoCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("videoMapper.selectVideoCount");
	}
	
	// 상품 리스트 가져오기
	public ArrayList<video> videoListAll(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("videoMapper.videoListAll", null, rowBounds);
	}
	
	// 자료실 리스트 갯수
	public ArrayList<video> videoDetail(SqlSessionTemplate sqlSession, int videoNo) {
		return (ArrayList)sqlSession.selectList("videoMapper.videoDetail", videoNo);
	}
	
	
}
