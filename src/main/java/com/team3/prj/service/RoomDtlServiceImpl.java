package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.RoomDtlDAO;
import com.team3.prj.vo.RoomDtlVO;



@Service
public class RoomDtlServiceImpl implements RoomDtlService {

	@Autowired
	RoomDtlDAO dao;

	@Override
	public List<RoomDtlVO> selectAll() {
		return dao.roomDtlSelectAll();
	}

	@Override
	public Long insert(RoomDtlVO vo) {
		return dao.roomDtlInsert(vo);
	}

	@Override
	public Long update(RoomDtlVO vo) {
		return dao.roomDtlUpdate(vo);
	}

	@Override
	public Long delete(RoomDtlVO vo) {
		return dao.roomDtlDelete(vo);
	}

}