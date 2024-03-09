package com.kh.product.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Payment {

	int userNo;
	int payPoint;
	Date PayDay;
	
}
