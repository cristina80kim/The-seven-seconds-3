package com.team3.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.EtcDAO;
import com.team3.prj.vo.NoteVO;

@Service
public class EtcServiceImpl implements EtcService {

    @Autowired
    EtcDAO dao;
    
    @Override
    public NoteVO select(NoteVO vo) {
        return dao.select(vo);
    }

    @Override
    public String insert(NoteVO vo) {
        return dao.insert(vo) == 1 ? vo.getId().toString() : "";
    }

    @Override
    public int update(NoteVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(NoteVO vo) {
        return dao.delete(vo);
    }

}
