package com.kh.member.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Member {

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private String age;
	private String phone;
	private String address;
	
	
}
