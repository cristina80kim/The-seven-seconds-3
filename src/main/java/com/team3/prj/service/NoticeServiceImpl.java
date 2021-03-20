package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.NoticeDAO;
import com.team3.prj.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeDAO noticeDao;
	
	@Override
	public List<NoticeVO> selectAllNotice(){
	return noticeDao.selectAllNotice();
	}

}
