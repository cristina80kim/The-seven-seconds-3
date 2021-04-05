package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteVO {
    private Long id;            // ID.
    private String title;       // 제목
    private String content;     // 내용
}
