package com.team3.prj.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
public class FooterController {
	// http://localhost:8081/header
	  
	  @RequestMapping("/footer")
	  public String test(){
	      return "footer";
	  }
	   
}