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
    
    // 기능: 공통코드를 읽기위해 CommonCodeVO를 생성하고 class1, class2를 할당함.
    public static CommonCodeVO createCommonCode(String class1, String class2) {
        CommonCodeVO result = new CommonCodeVO();
        result.class1 = class1;
        result.class2 = class2;
        return result;
    }

}
