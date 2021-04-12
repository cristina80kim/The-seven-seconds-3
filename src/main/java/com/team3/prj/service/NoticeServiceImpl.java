package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.NoticeDAO;
import com.team3.prj.vo.NoticeSearchVO;
import com.team3.prj.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeDAO dao;

	@Override
	public List<NoticeVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<NoticeVO> selectOne(NoticeVO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public List<NoticeVO> search(NoticeSearchVO svo) {
		return dao.search(svo);
	}

	@Override
	public Long insert(NoticeVO vo) {
		return dao.insert(vo);
	}

	@Override
	public Long update(NoticeVO vo) {
		return dao.update(vo);
	}

	@Override
	public Long delete(NoticeVO vo) {
		return dao.delete(vo);
	}
//

	@Override
	public Integer selectCnt(NoticeSearchVO svo) {
		// TODO Auto-generated method stub
		return dao.selectCnt(svo);
	}


}
