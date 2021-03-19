package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.FaqService;
import com.team3.prj.vo.FaqVO;


@Controller
public class FaqController {
	 @Autowired
	   FaqService faqService;

	   // http://localhost:8081/allfaq
	   @GetMapping("/allfaq")
	   public @ResponseBody List<FaqVO> selectAllFaq() {
	      System.out.println("selectAllFaq()");
	      List<FaqVO> lstFaq = faqService.selectAllFaq();
	      return lstFaq;
	   }
}
