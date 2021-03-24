package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// http://localhost:8081/index
		  @RequestMapping("/index")
	public String mainMenu() {
			  return "index";
	}
	
}
