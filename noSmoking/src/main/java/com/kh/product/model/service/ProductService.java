package com.kh.product.model.service;

import java.util.ArrayList;

import com.kh.common.vo.PageInfo;
import com.kh.product.model.vo.Cart;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductImg;

public interface ProductService {

	// 상품 등록
	int insertProduct(Product p);
	
	// 상품 이미지 
	int insertProductImg(ProductImg pi);
	
	// 총 상품 갯수 가져오기
	int selectListCount();
	
	// 상품 리스트 가져오기
	ArrayList<Product> selectProductList(PageInfo pi);
	
	// 상품 이미지 가져오기
	ArrayList<ProductImg> selectProductImg(int pNo);
	
	// 상품 디테일 정보 가져오기
	ArrayList<Product> productDetail(int pNo);
	
	// 상품 디테일 이미지 가져오기 
	ArrayList<ProductImg> productDetailImg(int pNo);
	
	// 장바구니에 이미 있는지 확인하기
	int selectCartShop(int userNo, int productNo);
	
	// 장바구니에 담기
	int insertCart(int userNo, int productNo, int count);
	
	// 장바구니 리스트
	ArrayList<Cart> selectCart(int userNo);
	
	// 장바구니 상품 리스트 
	ArrayList<Product> selectProduct(int productNo);
	
	// 장바구니 수량 업데이트
	int cartUpdateCount(int count, int userNo, int productNo);
	
	// 장바구니 삭제 
	int deleteCart(int productNo, int userNo);
	
	// 결제 내역 남기기 
	int insertPayment(int userNo, int point);
}
