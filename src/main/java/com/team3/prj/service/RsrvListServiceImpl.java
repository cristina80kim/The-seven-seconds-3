package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.RsrvListDAO;
import com.team3.prj.vo.RsrvListVO;

@Service
public class RsrvListServiceImpl implements RsrvListService {

	@Autowired
	RsrvListDAO rsrvlistDao;
	
	@Override
	public List<RsrvListVO> selectAllRsrvList(){
		return rsrvlistDao.selectAllRsrvList();
	}
	
	@Override
	public List<RsrvListVO> managerRsrvList(){
	    return rsrvlistDao.managerRsrvList();
	}
	
	@Override
	public Long delete(RsrvListVO vo) {
	    return rsrvlistDao.delete(vo);
	}
	
	@Override
	public Long update(RsrvListVO vo) {
	    return rsrvlistDao.update(vo)== 1? vo.getId() : 0;
	}
	
}
