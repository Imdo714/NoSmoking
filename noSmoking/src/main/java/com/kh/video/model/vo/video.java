package com.kh.video.model.vo;

import com.kh.product.model.vo.Cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class video {
	
	int videoNo;
	String videoContent;
	String videoUrl;
	int userNo;
	String userName;

}
