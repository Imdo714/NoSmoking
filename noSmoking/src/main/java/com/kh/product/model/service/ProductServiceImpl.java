package com.kh.product.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.vo.PageInfo;
import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.Cart;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductImg;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductDao pDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	@Override
	public int insertProduct(Product p) {
		return pDao.insertProduct(sqlSession, p);
	}

	@Override
	public int insertProductImg(ProductImg pi) {
		return pDao.insertProductImg(sqlSession, pi);
	}

	@Override
	public int selectListCount() {
		return pDao.selectListCount(sqlSession);
	}

	@Override
	public ArrayList<Product> selectProductList(PageInfo pi) {
		return pDao.selectProductList(sqlSession, pi);
	}

	@Override
	public ArrayList<ProductImg> selectProductImg(int pNo) {
		return pDao.selectProductImg(sqlSession, pNo);
	}

	@Override
	public ArrayList<Product> productDetail(int pNo) {
		return pDao.productDetail(sqlSession, pNo);
	}

	@Override
	public ArrayList<ProductImg> productDetailImg(int pNo) {
		return pDao.productDetailImg(sqlSession, pNo);
	}

	@Override
	public int insertCart(int userNo, int productNo, int count) {
		return pDao.insertCart(sqlSession, userNo, productNo, count);
	}

	@Override
	public ArrayList<Cart> selectCart(int userNo) {
		return pDao.selectCart(sqlSession, userNo);
	}

	@Override
	public ArrayList<Product> selectProduct(int productNo) {
		return pDao.selectProduct(sqlSession, productNo);
	}

	@Override
	public int selectCartShop(int userNo, int productNo) {
		return pDao.selectCartShop(sqlSession, userNo, productNo);
	}

	@Override
	public int cartUpdateCount(int count, int userNo, int productNo) {
		return pDao.cartUpdateCount(sqlSession, count, userNo, productNo);
	}

	@Override
	public int deleteCart(int productNo, int userNo) {
		return pDao.deleteCart(sqlSession, productNo, userNo);
	}

	@Override
	public int insertPayment(int userNo, int point) {
		return pDao.insertPayment(sqlSession, userNo, point);
	}


}
