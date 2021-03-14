package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.EmpDAO;
import com.team3.prj.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

   @Autowired
   EmpDAO empDao;
   
   @Override
   public List<EmpVO> selectAllEmps() {
      return empDao.selectAllEmps();
   }
}
