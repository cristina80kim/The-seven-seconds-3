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
		return dao.qnaSelectAll();
	}

	@Override
	public Long insert(QnaVO vo) {
		return dao.qnaInsert(vo) == 1 ? vo.getId() : 0;
	}

	@Override
	public Long qupdate(QnaVO vo) {
		return dao.qUpdate(vo)== 1 ? vo.getId() : 0;

	}

	@Override
	public Long aupdate(QnaVO vo) {
		return dao.qUpdate(vo)== 1 ? vo.getId() : 0;

	}

	@Override
	public Long delete(QnaVO vo) {
		return dao.qnaDelete(vo);
	}


	@Override
	public List<QnaVO> qnaSearch(QnaSearchVO svo) {
		return dao.qnaSearch(svo);
	}
}