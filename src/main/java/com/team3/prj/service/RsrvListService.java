package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.RsrvListVO;

public interface RsrvListService {

	public List<RsrvListVO> selectAllRsrvList();
	
	
	public List<RsrvListVO> managerRsrvList();
	
	public Long delete(RsrvListVO vo);
	
	public Long update(RsrvListVO vo);
}
