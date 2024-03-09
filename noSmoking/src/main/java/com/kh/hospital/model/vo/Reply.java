package com.kh.hospital.model.vo;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Reply {

	int replyNo;
	String replyContent;
	Date repltDay;
	int userNo;
	int hospitalNo;
	String userName;
}
