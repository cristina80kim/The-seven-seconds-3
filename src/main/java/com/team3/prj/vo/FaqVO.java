package com.team3.prj.vo;

import lombok.Data;

@Data
public class FaqVO {
	private String no; //글번호
	private String cateId; //공통코드
	private String title; //제목
	private String content; //내용
	private String cUser; //생성자id
}
