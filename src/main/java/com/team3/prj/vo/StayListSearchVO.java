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
	private String isHotel; //호텔
	private String isMotel; //모텔
	private String isPension; //펜션/풀빌라
	private String isGlamping;//글램핑/캠핑
	private String isGuestHouse;//게하/한옥
	private String isResort;//리조트/콘도
	private String keyword; //검색창
	private String checkin; //예약테이블 (체크인)
	private String checkout; //예약테이블 (체크아웃)
}
