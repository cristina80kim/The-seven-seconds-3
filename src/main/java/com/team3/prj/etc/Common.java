package com.team3.prj.etc;

public class Common {

    //----------
    // 작성자 정보
    //----------
    public static final String strMaker = "(c)opyleft 2021 The Team Three";

    //----------
    // Role 정보
    //----------
    public static final String strRoleAdmin = "A";     // Superuser
    public static final String strRoleManager = "M";   // 숙소 관리자
    public static final String strRoleUser = "U";      // 일반 사용자
    public static final String strRoleAnonymous = "Y"; // 로긴 안 한 익명 사용자

    public static final String strRoleA = strRoleAdmin;
    public static final String strRoleM = strRoleManager;
    public static final String strRoleU = strRoleUser;
    public static final String strRoleY = strRoleAnonymous;

    public static final String strRoleAMUY = strRoleA + strRoleM + strRoleU + strRoleY;
    public static final String strRoleAMY = strRoleA + strRoleM + strRoleY;
    public static final String strRoleAUY = strRoleA + strRoleU + strRoleY;


    //----------
    // Note 테이블 title 정보
    //----------
    public static final String strNoteTermsOfService = "Terms Of Service"; // 이용약관
    public static final String strNotePrivacyPolicy = "Privacy Policy";     // 개인정보처리방침

}
