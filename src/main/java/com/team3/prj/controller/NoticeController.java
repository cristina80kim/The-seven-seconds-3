package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.NoticeService;
import com.team3.prj.vo.NoticeVO;
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	//http://localhost:8081/allnotice
	@GetMapping("/allnotice")
	public @ResponseBody List<NoticeVO> selectAllNotice(){
		System.out.println("selectAllNotice()");
		List<NoticeVO> lstNotice = noticeService.selectAllNotice();
		return lstNotice;
	}
}
