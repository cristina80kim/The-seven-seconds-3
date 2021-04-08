package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StayListVO {

    private String region;          // 지역구분
    private String title;           // 숙소명
    private String addr;            // 주소
    private String pic1Uuid;        // 수속 이미지 #1
    private String typeOfAcco;      // 숙박시설 유형
    private String typeOfAccoName;  // 숙박시설 유형(공통코드 class1='ROOM", class2="TYPE_OF_ACCO"인 name 값)
    private int weekdayPrice;       // 주중가격
    private int weekendPrice;       // 주말가격
    private int star;               // 별점
}