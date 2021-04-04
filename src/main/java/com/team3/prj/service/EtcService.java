package com.team3.prj.service;

import com.team3.prj.vo.EtcVO;

public interface EtcService {

    public String select(EtcVO vo);

    public String insert(EtcVO vo);

    public int update(EtcVO vo);
    
    public int delete(EtcVO vo);
}
