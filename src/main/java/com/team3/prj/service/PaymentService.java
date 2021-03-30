package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.PaymentVO;

public interface PaymentService {

	public List<PaymentVO> selectAllPayment();

    public Long dbinsert(PaymentVO vo);
	
	
	
}
