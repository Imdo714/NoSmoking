package com.kh.product.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.common.vo.PageInfo;
import com.kh.product.model.vo.Cart;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductImg;

@Repository
public class ProductDao {

	// 상품 내용 등록
	public int insertProduct(SqlSessionTemplate sqlSession, Product p) {
		return sqlSession.insert("productMapper.insertProduct", p);
	}
	
	// 상품 이미지 등록
	public int insertProductImg(SqlSessionTemplate sqlSession, ProductImg pi) {
		return sqlSession.insert("productMapper.insertProductImg", pi);
	}
	
	// 상품 총갯수
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("productMapper.selectListCount");
	}
	
	// 상품 리스트 가져오기
	public ArrayList<Product> selectProductList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectProductList", null, rowBounds);
	}
	
	// 상품 이미지 가져오기
	public ArrayList<ProductImg> selectProductImg(SqlSessionTemplate sqlSession, int pNo) {
		return (ArrayList)sqlSession.selectList("productMapper.selectProductImg", pNo);
	}
	
	// 상품 디테일 정보 가져오기
	public ArrayList<Product> productDetail(SqlSessionTemplate sqlSession, int pNo) {
		return (ArrayList)sqlSession.selectList("productMapper.productDetail", pNo);
	}
	
	// 상품 디테일 이미지 가져오기
	public ArrayList<ProductImg> productDetailImg(SqlSessionTemplate sqlSession, int pNo) {
		return (ArrayList)sqlSession.selectList("productMapper.selectProductImg", pNo);
	}
	
	// 상품 총갯수
	public int insertCart(SqlSessionTemplate sqlSession, int userNo, int productNo, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("productNo", productNo);
		params.put("count", count);
		
		return sqlSession.insert("productMapper.insertCart", params);
	}
	
	// 상품 디테일 이미지 가져오기
	public ArrayList<Cart> selectCart(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("productMapper.selectCart", userNo);
	}
	
	// 상품 리스트 가져오기
	public ArrayList<Product> selectProduct(SqlSessionTemplate sqlSession, int productNo) {
		return (ArrayList)sqlSession.selectList("productMapper.selectProduct", productNo);
	}
	
	// 상품 총갯수
	public int selectCartShop(SqlSessionTemplate sqlSession, int userNo, int productNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("productNo", productNo);
		
		Integer result = sqlSession.selectOne("productMapper.selectCartShop", params);
	    return (result != null) ? 1 : 0;
	}
	
	// 상품 총갯수
	public int cartUpdateCount(SqlSessionTemplate sqlSession, int count, int userNo, int productNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("count", count);
		params.put("userNo", userNo);
		params.put("productNo", productNo);
		
	    return sqlSession.update("productMapper.cartUpdateCount", params);
	}
	
	// 상품 총갯수
	public int deleteCart(SqlSessionTemplate sqlSession, int productNo, int userNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productNo", productNo);
		params.put("userNo", userNo);
		
	    return sqlSession.delete("productMapper.deleteCart", params);
	}
	
	// 상품 내용 등록
	public int insertPayment(SqlSessionTemplate sqlSession, int userNo, int point) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("point", point);
		
		return sqlSession.insert("productMapper.insertPayment", params);
	}
		
}
