package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StayListSearchVO2 {
//수정
    private String mstId;           // 마스터아이
    private String dtlid;           // 아이디
    private String keyword;         // 검색어
    private String checkIn;         // 예약테이블(체크인)
    private String checkOut;        // 예약테이블(체크아웃)
    private Integer numOfGuests;    // 인원수
    private Integer minPrice;       // 가격(하한값)
    private Integer maxPrice;       // 가격(상한값)
    private String[] typeOfAcco;    // 숙소유형(호텔, 모텔, 펜션/풀빌라, 글램핑/캠핑, 게하/한옥, 리조트/콘도)
    private String sortMethod;      // "star": 별점순, "revu": 후기순, "price": 가격순

    public StayListSearchVO2(StayListSearchVO vo) {
        int idx = 0;
        this.typeOfAcco = new String[6];

        this.dtlid       = vo.getDtlid();
        this.keyword     = vo.getKeyword();
        this.checkIn     = vo.getCheckIn();
        this.checkOut    = vo.getCheckOut();
        this.numOfGuests = vo.getNumOfGuests();
        this.minPrice    = vo.getMinPrice();
        this.maxPrice    = vo.getMaxPrice();

        this.typeOfAcco[idx++] = vo.getIsHotel();
        this.typeOfAcco[idx++] = vo.getIsMotel();
        this.typeOfAcco[idx++] = vo.getIsPension();
        this.typeOfAcco[idx++] = vo.getIsGlamping();
        this.typeOfAcco[idx++] = vo.getIsGuestHouse();
        this.typeOfAcco[idx++] = vo.getIsResort();

        this.sortMethod = vo.getSortMethod();
    }
}
