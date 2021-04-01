package com.team3.prj.vo;

import lombok.Data;

@Data
public class NoticeVO {
	 private String nickname;      	//닉네임
	 private String no;             //글번호  
	 private String title;          //공지사항 제목
	 private String content;		//공지사항 내용
	 private String cUser;          //생성자 ID
	 private String mUser;          //수정자 ID
	 private String cDate;          //생성 날짜/시간
	 private String mDate;          //수정 날짜/시간
	
}
