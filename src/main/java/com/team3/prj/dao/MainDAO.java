package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.CommonCodeVO; 

@Mapper
public interface MainDAO {
   public List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo);
}
