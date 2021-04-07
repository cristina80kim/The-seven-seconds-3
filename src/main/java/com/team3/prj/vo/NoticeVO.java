package com.team3.prj.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private Long id;			// 공지사항 아이디
	private String nickname;	// 닉네임
	private String no; 			// 글번호
	private String title; 		// 공지사항 제목
	private String content; 	// 공지사항 내용
	private String c_user; 		// 생성자 ID
	private String m_user; 		// 수정자 ID
	private String c_date; 		// 생성 날짜/시간
	private String m_date; 		// 수정 날짜/시간 

}
