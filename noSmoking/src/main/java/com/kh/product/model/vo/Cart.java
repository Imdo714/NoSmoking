package com.kh.product.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Cart {

	int userNo;
	int productNo;
	String cartCount;
}
