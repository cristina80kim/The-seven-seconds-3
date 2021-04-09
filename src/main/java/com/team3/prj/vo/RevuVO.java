package com.team3.prj.vo;

import lombok.Data;

@Data
public class RevuVO {
	private String id; //ID
	private String room_dtl_id;
	private String nickname; //닉네임
	private String content; //내용
	private String star; //별점(1~5)
	private String c_user; // 생성자
	private String c_date;
	private String m_date; // 수정날짜

} 