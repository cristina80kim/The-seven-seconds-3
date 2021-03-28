package com.team3.prj.vo;

import lombok.Data;

@Data
public class CommonCodeVO {
    Long id;          // ID.
    String class1;    // 대분류(분류1)   
    String class2;    // 중분류(분류2)
    String class3;    // 소분류(분류3)
    String class4;    // 세분류(?)(분류4)
    String name;      // 분류명
    String dtl;       // 상세 설명
    String extInfo;   // 추가정보
    String cUser;     // 생성자 ID.

}
