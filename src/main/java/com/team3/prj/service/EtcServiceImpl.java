package com.team3.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.EtcDAO;
import com.team3.prj.vo.EtcVO;

@Service
public class EtcServiceImpl implements EtcService {

    @Autowired
    EtcDAO dao;
    
    @Override
    public String select(EtcVO vo) {
        return dao.select(vo);
    }

    @Override
    public String insert(EtcVO vo) {
        return dao.insert(vo) == 1 ? vo.getId().toString() : "";
    }

    @Override
    public int update(EtcVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(EtcVO vo) {
        return dao.delete(vo);
    }

}
