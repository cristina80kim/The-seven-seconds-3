package com.team3.prj.vo;

import lombok.Data;

@Data
public class PaymentVO {
	
    private String rsrvStay; //예약숙소
	private String rsrvRoom; //예약방
	private String rsrvInfo; //예약정보
	private int price;  //가격
	private String rsrvName; //예약자 이름
	
	
	private Long id;   // ID
	private Long name; // 숙소이름
	private Long amount; //결제가격
	private Long buyer_email; //구매자이메일
	private Long buyer_name; //구매자이름
	
	
}
