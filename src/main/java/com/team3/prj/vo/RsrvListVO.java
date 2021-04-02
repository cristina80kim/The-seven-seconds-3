package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RsrvListVO {
	
    private Long id;   // ID
    private String checkIn; //체크인
    private String checkOut; //체크아웃
    private String name; // 숙소이름
    private String rsrvRoom; // 룸명
    private String rsrvId; //예약자 id
    private String rsrvGen; //예약자 성별
    private String rsrvTel; //예약자 전화번호
    private int amount; //결제가격
    private String rsrvInfo; //결제 정보(네이버페이 카카오페이)
    private String rsrvState; // 예약 상태('1': 예약완료(=결제완료), '2': 예약취소(=환불요청), '3': 환불완료, '9': 처리종료)
}
