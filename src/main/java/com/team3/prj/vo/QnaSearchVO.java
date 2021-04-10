package com.team3.prj.vo;

import lombok.Data;

@Data // getter setter 자동
public class QnaSearchVO {
	private String keyword;  // 검색 단어
	private String cate_id; // 카테고리 값 
	private String pageNumber;	// 페이지  번호
}
