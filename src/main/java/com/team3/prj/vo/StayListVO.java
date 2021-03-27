package com.team3.prj.vo;

import lombok.Data;

@Data
public class StayListVO {

	public String region;// 지역
	public String title; //숙소명
	public String addr; //주소
	public int weekday_Price; // 주중가격
	public int weekend_Price; // 주말가격
	//public int star; // 별점
}
