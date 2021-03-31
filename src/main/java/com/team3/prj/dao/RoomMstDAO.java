package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RoomMstSearchVO;
import com.team3.prj.vo.RoomMstVO;

@Mapper
public interface RoomMstDAO {
	public List<RoomMstVO> roomMstSelectAll();

	public Long roomMstInsert(RoomMstVO vo);
	
	public Long roomMstUpdate(RoomMstVO vo);
	
	public Long roomMstDelete(RoomMstVO vo);

	public List<RoomMstVO> roomMstSearch(RoomMstSearchVO svo);

	public List<RoomMstVO> roomMstOneSelect(RoomMstVO vo);
	
}