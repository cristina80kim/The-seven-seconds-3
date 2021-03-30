package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.StayListService;
import com.team3.prj.vo.StayListSearchVO;
import com.team3.prj.vo.StayListVO;

@Controller
@RequestMapping("/staylist")
public class StayListController {
private final String className="StayListController";
	@Autowired
	StayListService stayService;
	
	//http://localhost:8081/staylist/listall
	@GetMapping("/listall")
	public @ResponseBody List<StayListVO> StayListAll() {
		System.out.println(className+".StayListAll()");
		return stayService.StayListAll();
	}
	
	//http://localhost:8081/staylist/userRoomList 
	@PostMapping("/userRoomList")
	public String userRoomList (@RequestBody StayListSearchVO vo) {
		System.out.println(className+".userRoomList()");
		System.out.println(vo);
		return "user_RoomList";
	}
	
	
}
