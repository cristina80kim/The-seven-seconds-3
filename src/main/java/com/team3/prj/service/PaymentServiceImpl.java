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
	public String dbinsert(PaymentVO vo) {
	    System.out.println();
	    return paymentDao.dbinsert(vo) == 1 ? vo.getBuyerName(): "";
	}
	
	@Override
	public List<PaymentVO> selectPaymentend(){
	    return paymentDao.selectPaymentend();
	}
	
	@Override
	public Long delete(PaymentVO vo) {
	    return paymentDao.delete(vo);
	}
}
