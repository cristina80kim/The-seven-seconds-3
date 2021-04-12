package com.team3.prj.vo;

import lombok.Data;

@Data
public class NoticeSearchVO {

	private String keyword; // 검색어 
	private String pageNumber; 	//페이지 번호
	private String cateId;
}
