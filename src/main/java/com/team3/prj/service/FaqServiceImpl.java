package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.FaqDAO;
import com.team3.prj.vo.FaqSearchVO;
import com.team3.prj.vo.FaqVO;
import com.team3.prj.vo.NoticeSearchVO;


@Service
public class FaqServiceImpl implements FaqService {
	@Autowired
	  FaqDAO dao;

	@Override
	public List<FaqVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<FaqVO> selectOne(FaqVO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public List<FaqVO> search(FaqSearchVO svo) {
		return dao.search(svo);
	}

	@Override
	public Long insert(FaqVO vo) {
		return dao.insert(vo);
	}

	@Override
	public Long update(FaqVO vo) {
		return dao.update(vo);
	}

	@Override
	public Long delete(FaqVO vo) {
		return dao.delete(vo);
	}

	public Integer selectCnt(FaqSearchVO svo) {
		// TODO Auto-generated method stub
		return dao.selectCnt(svo);
	}
	   
	
}
