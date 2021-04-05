package com.team3.prj.vo;

import com.team3.prj.etc.Common;

import lombok.Data;

@Data
public class NoteVO {
    private Long id;            // ID.
    private String title;       // 제목
    private String content;     // 내용
    
    public NoteVO() {}

    public NoteVO(String title) { this.title = title; }
    
    // 기능: "이용약관"을 위한 조회 record 생성
    public static NoteVO createTermsOfService() {
        return new NoteVO(Common.strNoteTermsOfService);
    }

    // 기능: "개인정보보호정책"을 위한 조회 record 생성
    public static NoteVO createPrivacyPolicy() {
        return new NoteVO(Common.strNotePrivacyPolicy);
    }
}
