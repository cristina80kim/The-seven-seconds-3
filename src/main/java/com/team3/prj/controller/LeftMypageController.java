package com.team3.prj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LeftMypageController {
	// http://localhost:8081/leftMypage
	  
	  @RequestMapping("/leftMypage")
	  public String test(){
	      return "leftMypage";
	  }
}