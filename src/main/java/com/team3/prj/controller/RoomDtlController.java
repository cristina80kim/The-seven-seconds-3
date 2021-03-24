package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.RoomDtlService;
import com.team3.prj.vo.RoomDtlVO;


@Controller
@RequestMapping("/roomDtl")
public class RoomDtlController {
	private final String className = "RoomDtlController";

	@Autowired
	RoomDtlService service;

   	// http://localhost:8081/roomDtl/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<RoomDtlVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	/*
	 * @GetMapping("/insert") public @ResponseBody String insert(RoomMstVO vo) {
	 * System.out.println(className + ".insert(): " + vo.toString()); return
	 * service.insert(vo).toString(); //@ }
	 */

}