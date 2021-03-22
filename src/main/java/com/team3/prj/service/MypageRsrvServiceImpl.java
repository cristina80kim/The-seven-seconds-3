package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.MypageRsrvDAO;
import com.team3.prj.vo.MypageRsrvVO;

@Service
public class MypageRsrvServiceImpl implements MypageRsrvService {

	@Autowired
	MypageRsrvDAO mypageRsrvDao;
	
	@Override
	public List<MypageRsrvVO> selectAllMypage(){
		return mypageRsrvDao.selectAllMypage();
	}
}
