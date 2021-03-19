package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.FaqDAO;
import com.team3.prj.vo.FaqVO;


@Service
public class FaqServiceImpl implements FaqService {
	@Autowired
	  FaqDAO faqDao;
	   
	@Override
	   public List<FaqVO> selectAllFaq() {
	      return faqDao.selectAllFaq();
	   }
}
