package com.team3.prj.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private Long id;			// 공지사항 아이디
	private String nickname;	// 닉네임
	private String no; 			// 글번호
	private String title; 		// 공지사항 제목
	private String content; 	// 공지사항 내용
	private String cuser; 		// 생성자 ID
	private String muser; 		// 수정자 ID
	private String cdate; 		// 생성 날짜/시간
	private String mdate; 		// 수정 날짜/시간 

}
