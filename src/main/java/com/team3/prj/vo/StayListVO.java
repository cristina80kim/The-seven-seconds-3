package com.team3.prj.vo;

import lombok.Data;

@Data
public class StayListVO {

	public String region;//지역
	public String title; //숙소명
	public String addr; //주소
	public int weekday_Price; //평일가격
	public int weekend_Price; //휴일가격
	//public int star; //별점
}
