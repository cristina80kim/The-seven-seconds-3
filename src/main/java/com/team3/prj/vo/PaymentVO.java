package com.team3.prj.vo;

import lombok.Data;

@Data
public class PaymentVO {
	private String rsrvStay; //숙소명
	private String rsrvRoom; // 룸
	private String rsrvInfo; // 결제수단
	private int price; // 가격
	private String rsrvName; // 예약자
	
}
