package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StayListSearchVO {
//수정
    private String mstId;       //마스터아이
    private String dtlid;       //아이디   
    private String keyword;     //검색어
    private String checkIn;     //예약테이블(체크인)
    private String checkOut;    //예약테이블(체크아웃)
    private int numOfGuests;    //인원수
    private int minPrice;       //가격(하한값)
    private int maxPrice;       //가격(상한값)
    private String isHotel;     //숙소유형(호텔)
    private String isMotel;     //숙소유형(모텔)
    private String isPension;   //숙소유형(펜션/풀빌라)
    private String isGlamping;  //숙소유형(글램핑/캠핑)
    private String isGuestHouse;//숙소유형(게하/한옥)
    private String isResort;    //숙소유형(리조트/콘도)
}
