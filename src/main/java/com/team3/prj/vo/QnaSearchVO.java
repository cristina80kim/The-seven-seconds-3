package com.team3.prj.vo;

import lombok.Data;

@Data // getter setter 자동
public class QnaSearchVO {
	private String keyWord;  // 검색 단어
	private String cateId; // 카테고리 값 
}
