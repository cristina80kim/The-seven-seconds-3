package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.PaymentDAO;
import com.team3.prj.vo.PaymentVO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDAO paymentDao;
	
	@Override
	public List<PaymentVO> selectAllPayment(){
		return paymentDao.selectAllPayment();
	}

	@Override
	public Long dbinsert(PaymentVO vo) {
	    return paymentDao.dbinsert(vo) == 1 ? vo.getBuyer_name():0;
	}
}
