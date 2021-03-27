package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.StayListSearchVO;
import com.team3.prj.vo.StayListVO;

@Mapper
public interface StayListDAO { //수정
	public List<StayListVO> StayListAll();
	
	public List<StayListSearchVO> SearchAll();

}
