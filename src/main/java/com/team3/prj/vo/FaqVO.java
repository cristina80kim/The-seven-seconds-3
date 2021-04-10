package com.team3.prj.vo;

import lombok.Data;

@Data
public class FaqVO {
	private Long id; 		// 고유id
	private String no; 		// 글번호
	private String cateId; // 카테고리
	private String cate;	// 카테고리명
	private String title; 	// 제목
	private String content; // 내용
	private String cUser; 	// 글쓴이
	private String cdate;	// 생성 일자,시간
}
