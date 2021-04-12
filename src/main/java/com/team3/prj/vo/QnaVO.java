package com.team3.prj.vo;

import lombok.Data;

@Data // getter setter 자동
public class QnaVO {
	private Long id; 	// ID
	private String nickname; //닉네임
	private String no; //글번호
	private String cate_id; //공통코드 faq_cate 참조
	private String cate;	// 카테고리명
	private String is_pub; //'Y' 공개글 'N' 비밀글
	private String title; //제목
	private String q; //질문 내용
	private String a; //답변 내용
	private String aox; //답변유무
	private String cuser; // 생성자
	private String cdate; // 생성날짜
	private String muser; // 수정자
	private String mdate; // 수정날짜


	// 커밋
	 
	/*
	 * #{nickname}, #{no}, #{cateId},  #{isPub}, #{title}, #{q}, #{cUser})
	 */
}
