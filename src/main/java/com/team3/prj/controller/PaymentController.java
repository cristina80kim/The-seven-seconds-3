package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.PaymentService;
import com.team3.prj.vo.PaymentVO;

@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	//http://localhost:8081/allpayment
	@GetMapping("/allpayment")
	public @ResponseBody List<PaymentVO> selectAllPayment(){
		System.out.println("selectAllPayment()");
		List<PaymentVO> lstPayment = paymentService.selectAllPayment();
				return lstPayment;
	}
	
	
	//수정
	//http://localhost:8081/userRoomPay
	@GetMapping("/userRoomPay")
	public String userRoomPay() {
	    return "user_RoomPay";
	}
	
	
}
