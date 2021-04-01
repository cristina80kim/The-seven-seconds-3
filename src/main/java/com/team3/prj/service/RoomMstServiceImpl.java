package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.RoomMstDAO;
import com.team3.prj.vo.RoomMstSearchVO;
import com.team3.prj.vo.RoomMstVO;

@Service
public class RoomMstServiceImpl implements RoomMstService {

	@Autowired
	RoomMstDAO dao;

	@Override
	public List<RoomMstVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Long insert(RoomMstVO vo) {
		return dao.insert(vo) == 1 ? vo.getId() : 0;
	}

	@Override
	public Long update(RoomMstVO vo) {
		return dao.update(vo);
	}

	@Override
	public Long delete(RoomMstVO vo) {
		return dao.delete(vo);
	}

	@Override
	public List<RoomMstVO> search(RoomMstSearchVO svo) {
		return dao.search(svo);
	}

	@Override
	public List<RoomMstVO> selectOne(RoomMstVO vo) {
		
		return dao.selectOne(vo);
	}

}