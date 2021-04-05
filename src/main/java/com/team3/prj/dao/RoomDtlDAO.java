package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RoomDtlSerchVO;
import com.team3.prj.vo.RoomDtlVO;

@Mapper
public interface RoomDtlDAO {
	public List<RoomDtlVO> selectAll();

	public Long insert(RoomDtlVO vo);

	public Long update(RoomDtlVO vo);

	public Long delete(RoomDtlVO vo);

	public List<RoomDtlVO> search(RoomDtlSerchVO svo);
}