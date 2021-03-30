package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RoomDtlVO;

@Mapper
public interface RoomDtlDAO {
	public List<RoomDtlVO> roomDtlSelectAll();

	public Long roomDtlInsert(RoomDtlVO vo);

	public Long roomDtlUpdate(RoomDtlVO vo);

	public Long roomDtlDelete(RoomDtlVO vo);
}