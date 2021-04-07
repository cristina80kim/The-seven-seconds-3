package com.team3.prj.vo;

import lombok.Data;

@Data // getter setter 자동
public class QnaVO {
	private Long id; 	// ID
	private String nickname; //닉네임
	private String no; //글번호
	private String cateId; //공통코드 faq_cate 참조
	private String isPub; //'Y' 공개글 'N' 비밀글
	private String title; //제목
	private String q; //질문 내용
	private String a; //답변 내용
	private String c_user; // 생성자
	private String c_date; // 생성날짜
	private String m_user; // 수정자
	private String m_date; // 수정날짜


	 
	/*
	 * #{nickname}, #{no}, #{cateId},  #{isPub}, #{title}, #{q}, #{cUser})
	 */
}
