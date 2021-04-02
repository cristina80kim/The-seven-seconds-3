package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaymentVO {
    
    
    private Long id;   // ID
    private String checkIn; //체크인
    private String checkOut; //체크아웃
    private String name; // 숙소이름
    private String rsrvRoom; // 룸명
    private Long roomDtlId; //룸(객실) id(fk)
    private String rsrvId; //예약자 id
    private String rsrvGen; //예약자 성별
    private String rsrvTel; //예약자 전화번호
    private int amount; //결제가격
    private String rsrvInfo; //결제 정보(네이버페이 카카오페이)
    private String apprNo; //승인번호
    private String rsrvState; // 예약 상태('1': 예약완료(=결제완료), '2': 예약취소(=환불요청), '3': 환불완료, '9': 처리종료)
    private String cUser; //생성자id
    private String mUser; //수정자id
    private String cDate; //생성날짜
    private String mDate; //수정날짜
    private String buyerEmail; //구매자이메일
    private String buyerName; //구매자이름
    
}
