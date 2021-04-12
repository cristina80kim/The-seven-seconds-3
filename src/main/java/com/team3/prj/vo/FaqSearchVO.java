package com.team3.prj.vo;

import lombok.Data;

@Data
public class FaqSearchVO {
	
	private String keyword; //검색어
	private String cateId; //카테고리
	private String pageNumber;	// 페이지  번호

}
