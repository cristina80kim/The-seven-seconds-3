package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.RoomDtlVO;


public interface RoomDtlService {
	public List<RoomDtlVO> selectAll();

	public Long insert(RoomDtlVO vo);
}