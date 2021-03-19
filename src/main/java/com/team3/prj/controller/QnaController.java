package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.QnaService;
import com.team3.prj.vo.QnaVO;


//http://localhost:8081/Qna/selectAll
@Controller
@RequestMapping("/Qna") //모든 클래스안에 있는것에 적용 실행하면 /Qna/selectAll이 실행됨
public class QnaController {
	
	@Autowired
	QnaService service;

	@GetMapping("/selectAll")
	public @ResponseBody List<QnaVO> selectAll() { //json형태로 받는거 @ResponseBody
		System.out.println("selectAll()");
		return service.selectAll(); //serviceimpl에 selectAll로 감
	}
	

	@GetMapping("/insert") //qna/insert
	public @ResponseBody String insert(QnaVO param) {
		System.out.println("insert()");
		return service.insert(param);
	}

}
