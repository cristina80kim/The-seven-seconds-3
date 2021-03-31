package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.PaymentVO;

@Mapper
public interface PaymentDAO {

	public List<PaymentVO> selectAllPayment();

    public Long dbinsert(PaymentVO vo);
}
