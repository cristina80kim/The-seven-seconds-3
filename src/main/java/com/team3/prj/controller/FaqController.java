package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.FaqSearchVO;
import com.team3.prj.service.FaqService;
import com.team3.prj.vo.FaqVO;

@Controller
@RequestMapping("/Faq")
public class FaqController {
	private final String className = "FaqController";

	@Autowired
	FaqService service;

//	전체 출력
//	http://localhost:8081/Faq/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<FaqVO> selectAll() {
		System.out.println(className + "selectAll()");
		return service.selectAll();
	}
	
//	1개 출력
//	http://localhost:8081/Faq/selectOne?id=
	@GetMapping("/selectOne")
	public @ResponseBody List<FaqVO> selectOne(FaqVO vo) {
		System.out.println(className + "selectOne()");
		return service.selectOne(vo);
	}
	
//	검색
//	http://localhost:8081/Faq/search?cateId=&keyWord=
	@GetMapping("/search")
	public @ResponseBody List<FaqVO> search(FaqSearchVO svo) {
		System.out.println(className + "search()");
		return service.search(svo);
	}
	
	
	
//	Faq 등록
//	http://localhost:8081/Faq/FaqWriter
	@GetMapping("/FaqWriter")
	public String FaqWriter() {
		return "admin_comu_FAQList_Write";
	}
	
//	http://localhost:8081/Faq/insert
	@GetMapping("/insert")
	public @ResponseBody String insert(FaqVO vo) {
		System.out.println(className + "insert()" + vo.toString());
		return service.insert(vo).toString();
	}
//	Faq 수정
//	http://localhost:8081/Faq/update
	@GetMapping("/update")
	public @ResponseBody String update(FaqVO vo) {
		System.out.println(className + "update()" + vo.toString());
		return service.update(vo).toString();
	}
//	Faq 삭제
//	http://localhost:8081/Faq/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(FaqVO vo) {
		System.out.println(className + "delete()" + vo.toString());
		return service.delete(vo).toString();
	}

}
