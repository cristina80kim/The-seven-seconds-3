package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.MypageRsrvVO;

@Mapper
public interface MypageRsrvDAO {
	public List<MypageRsrvVO> selectAllMypage();
	
	public Long MypageRsrvDelete(MypageRsrvVO vo);
}
