package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.QnaService;
import com.team3.prj.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	private final String className = "QnaController";

	@Autowired
	QnaService service;

    // http://localhost:8081/qna/frmSelectAll
    @GetMapping("/frmSelectAll")
    public String frmSelectAll() {
        System.out.println(className + ".frmSelectAll()");
        return "frmQnaSelectAll";  // .html
    }

	// http://localhost:8081/qna/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<QnaVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@GetMapping("/insert")
	public @ResponseBody String insert(QnaVO vo) {
		System.out.println(className + ".insert(): " + vo.toString());
		return service.insert(vo).toString(); //@
	}

}