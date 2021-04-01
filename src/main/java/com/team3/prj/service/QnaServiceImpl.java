package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.QnaDAO;
import com.team3.prj.vo.QnaSearchVO;
import com.team3.prj.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDAO dao;

	@Override
	public List<QnaVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Long insert(QnaVO vo) {
		return dao.insert(vo) == 1 ? vo.getId() : 0;
	}

	@Override
	public Long updateQ(QnaVO vo) {
		return dao.updateQ(vo)== 1 ? vo.getId() : 0;

	}

	@Override
	public Long updateA(QnaVO vo) {
		return dao.updateA(vo)== 1 ? vo.getId() : 0;

	}

	@Override
	public Long delete(QnaVO vo) {
		return dao.delete(vo);
	}


	@Override
	public List<QnaVO> search(QnaSearchVO svo) {
		return dao.search(svo);
	}

	@Override
	public List<QnaVO>selectOne(QnaVO vo) {
		return dao.selectOne(vo);
	}
	//
}