package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.RoomMstVO;

public interface RoomMstService {
	public List<RoomMstVO> selectAll();

	public Long insert(RoomMstVO vo);
}