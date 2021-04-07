package com.team3.prj.vo;

import lombok.Data;

@Data
public class FaqVO {
	private Long id; 		// 고유id
	private String no; 		// 글번호
	private String cate_id; 	// 카테고리
	private String title; 	// 제목
	private String content; // 내용
	private String c_user; 	// 글쓴이
	private String c_date;	// 생성 일자,시간
}
