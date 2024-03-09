package com.kh.product.model.vo;

import com.kh.member.model.vo.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Product {
	
	int productNo;
	String productName;
	String productContent;
	String productPrice;
	
}
