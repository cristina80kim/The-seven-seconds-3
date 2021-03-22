package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.prj.service.StayListService;
import com.team3.prj.vo.StayListVO;

@Controller
@RequestMapping("/staylist")
public class StayListController {
private final String className="StayListController";
	@Autowired
	StayListService stayService;
	
	//http://localhost:8081/staylist/StayListAll
	@GetMapping("/StayListAll")
	public List<StayListVO> StayListAll() {
		System.out.println(className+".StayListAll()");
		return stayService.StayListAll();
	}
}
