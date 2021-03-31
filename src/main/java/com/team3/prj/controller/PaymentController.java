package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.PaymentService;
import com.team3.prj.service.UserService;
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
	
	
	
	//http://localhost:8081/userRoomPay
	@GetMapping("/userRoomPay")
	public String userRoomPay() {
	    return "user_RoomPay";
	}
	//http://localhost:8081/post
	@PostMapping("/post")
	//public @ResponseBody void dbinsert(Long amount,Long name,Long buyer_email,Long buyer_name) {
	public @ResponseBody void dbinsert(@RequestBody PaymentVO vo) {
	   // System.out.println(amount+name+buyer_email+buyer_name);
	    System.out.println(vo);
	    //paymentService.dbinsert(new PaymentVO(amount,name,buyer_email,buyer_name),0);
	    paymentService.dbinsert(vo);
	}

	//결제 취소시 메인으로 돌아옴
	//http://localhost:8081/userMain
	@GetMapping("/userMain")
	public String userMain() {
	    return "user_Main";
	}
	
	
	
}
