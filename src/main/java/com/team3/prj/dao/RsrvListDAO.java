package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RsrvListVO;

@Mapper
public interface RsrvListDAO {

	public List<RsrvListVO> selectAllRsrvList();
	
	public List<RsrvListVO> managerRsrvList();
	
	public Long update(RsrvListVO vo);
	
	public Long delete(RsrvListVO vo);
}
