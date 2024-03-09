package com.kh.hospital.model.vo;

import com.kh.product.model.vo.Cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Hospital {
	
	int hospitalNo;
	String hospitalName;
	String hospitalAddress;
	String hospitalPhone;
	String hospitalCity;
}
