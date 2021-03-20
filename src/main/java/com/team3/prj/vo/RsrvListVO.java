package com.team3.prj.vo;

import lombok.Data;

@Data
public class RsrvListVO {
	
	private String rsrvDate;//예약날자
	private String rsrvStay;//숙소
	private String rsrvRoom;//룸
	private String rsrvName;//예약자
	private String rsrvGen;//성별
	private String rsrvTel;//연락처
	private String rsrvInfo;//결제정보
	private int price;//가격
	private String rsrvState;//예약상태
	
}
