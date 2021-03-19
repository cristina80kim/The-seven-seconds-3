package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.UserService;
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/selectAll")
	public @ResponseBody List<UserVO> selectAll() {
		System.out.println("selectAll()");
		return service.selectAll();
	}
	

}
