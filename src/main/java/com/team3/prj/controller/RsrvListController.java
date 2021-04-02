package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.RsrvListService;
import com.team3.prj.vo.RsrvListVO;

@Controller
public class RsrvListController {

	@Autowired
	RsrvListService rsrvlistService;
	
	//http://localhost:8081/allrsrvlist
	@GetMapping("/allrsrvlist")
	public @ResponseBody List<RsrvListVO> selectAllRsrvList(){
		System.out.println("selectAllRsrvList()");
		List<RsrvListVO> lstRsrvList = rsrvlistService.selectAllRsrvList();
		return lstRsrvList;
	}
	
	// 230번 예약관리 예약리스트
	//http://localhost:8081/managerRsrvList
	@GetMapping("/managerRsrvList")
	public String managerRsrvList() {
	    return "manager_RsrvList";
	}
	
}
