package com.team3.prj.vo;

import lombok.Data;

@Data
//@Getter
public class UserInstanceVO {

    private String id;
    private String name;
    private String nickname;
    private String tel;
    private String email;
    private String gen;
    private String role;

    public UserInstanceVO(String id, String name, String nickname, String tel, String email, String gen, String role) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.tel = tel;
        this.email = email;
        this.gen = gen;
        this.role = role;
    }

    public UserInstanceVO(UserVO vo) {
        this.id = vo.getId();
        this.name = vo.getName();
        this.nickname = vo.getNickname();
        this.tel = vo.getTel();
        this.email = vo.getEmail();
        this.gen = vo.getGen();
        this.role = vo.getRole();
    }

}
