package com.team3.prj.service;

import com.team3.prj.vo.NoteVO;

public interface EtcService {

    public NoteVO select(NoteVO vo);

    public String insert(NoteVO vo);

    public int update(NoteVO vo);
    
    public int delete(NoteVO vo);
}
