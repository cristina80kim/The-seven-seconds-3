package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.MainDAO;
import com.team3.prj.vo.CommonCodeVO;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainDAO mainDao;
    
    @Override
    public List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo) {
        return mainDao.selectCommonCodes(vo);
    }

}
