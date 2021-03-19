package com.team3.prj.vo;

import lombok.Data;

@Data // getter setter 자동
public class QnaVO {

	private String nickname; //닉네임
	private String no; //글번호
	private String cate_id; //공통코드 faq_cate 참조
	private String is_pub; //'Y' 공개글 'N' 비밀글
	private String title; //제목
	private String q; //질문 내용
	private String a; //답변 내용
}
