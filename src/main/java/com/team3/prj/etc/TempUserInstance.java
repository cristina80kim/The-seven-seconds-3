package com.team3.prj.etc;

import com.team3.prj.vo.UserInstanceVO;

public class TempUserInstance {

    public static UserInstanceVO createTempㅁAdmin() {
        String id = "admin";
        String name = "대왕";
        String nickname = "TheGotFather";
        String tel = "01011112222";
        String email = "HisNameWasTheKing@gmail.com";
        String role = "M";
        
        return new UserInstanceVO(id, name, nickname, tel, email, role);
    }

    public static UserInstanceVO createTempManager() {
        String id = "7secs";
        String name = "칠초";
        String nickname = "TheSevenSeconds";
        String tel = "01011113333";
        String email = "TheSevenSeconds@gmail.com";
        String role = "M";
        
        return new UserInstanceVO(id, name, nickname, tel, email, role);
    }

    public static UserInstanceVO createTempUser() {
        String id = "queen";
        String name = "여왕";
        String nickname = "TheQueen";
        String tel = "01011114444";
        String email = "HerNameIsTheQueen@gmail.com";
        String role = "F";
        
        return new UserInstanceVO(id, name, nickname, tel, email, role);
    }

}
