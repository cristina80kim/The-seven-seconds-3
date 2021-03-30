package com.team3.prj.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AjaxTestVO {
    private String pub;
    private String name;
    private String age;
    private String tel;
    
    @Builder
    public AjaxTestVO(String pub, String name, String age, String tel) {
        this.pub = pub;
        this.name = name;
        this.age = age;
        this.tel = tel;
    }
}
