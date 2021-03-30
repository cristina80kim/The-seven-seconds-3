package com.team3.prj.vo;

import lombok.Data;

@Data
public class RoomDtlVO {
	private Long id;				// ID
	private String mstId;			// 숙소ID
	private String roomName;		// 룸명
	private String typeOfRoom;		// 룸종류(공통코드)
	private String numOfGuests;		// 인원수
	private String checkInTime;		// 체크인 시간
	private String checkOutTime;	// 체크아웃 시간
	private String weekdayPrice;	// 주중 금액
	private String weekendPrice;	// 주말(공휴일포함) 금액
	private String pic1Org;			// 룸이미지 1
	private String pic1Uuid;		// 룸이미지 UUID 1
	private String pic2Org;			// 룸이미지 2
	private String pic2Uuid;		// 룸이미지 UUID 2
	private String pic3Org;			// 룸이미지 3
	private String pic3Uuid;		// 룸이지미 UUID 3
	private String cUser;			// 생성자 ID
	private String mUser;			// 수정자 ID
	private String cDate;			// 생성 날짜
	private String mDate;			// 수정 날짜
}
