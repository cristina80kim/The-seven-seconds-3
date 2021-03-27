package com.team3.prj.vo;

import lombok.Data;

@Data
public class StayListSearchVO {
//수정
	private String mstId; //마스터아이
	private String dtlid; //아이디	
	private int weekdayPrice;
	private int weekendPrice; 
	private int numOfGuests;
	private String ishotel; //호텔
	private String ismotel; //모텔
	private String ispension; //펜션/풀빌라
	private String isglamping;//글램핑/캠핑
	private String isguestHouse;//게하/한옥
	private String isresort;//리조트/콘도
	private String keyword; //검색창
	private String checkin; //예약테이블 (체크인)
	private String checkout; //예약테이블 (체크아웃)
}
