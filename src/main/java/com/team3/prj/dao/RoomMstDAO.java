package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RoomMstSearchVO;
import com.team3.prj.vo.RoomMstVO;

@Mapper
public interface RoomMstDAO {
	public List<RoomMstVO> selectAll();

	public Long insert(RoomMstVO vo);
	
	public Long update(RoomMstVO vo);
	
	public Long delete(RoomMstVO vo);

	public List<RoomMstVO> search(RoomMstSearchVO svo);

	public List<RoomMstVO> selectOne(RoomMstVO vo);
	
}