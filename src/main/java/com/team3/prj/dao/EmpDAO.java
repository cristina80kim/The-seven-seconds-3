package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.EmpVO; 

@Mapper
public interface EmpDAO {
   public List<EmpVO> selectAllEmps();
   public int getNum();
}
