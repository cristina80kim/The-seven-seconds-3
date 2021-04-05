package com.team3.prj.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Libs;
import com.team3.prj.service.FaqService;
import com.team3.prj.vo.FaqSearchVO;
import com.team3.prj.vo.FaqVO;

@Controller
@RequestMapping("/faq")
public class FaqController {
	private final String className = "FaqController";

	@Autowired
	FaqService service;

//	전체 출력
//	http://localhost:8081/faq/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<FaqVO> selectAll() {
		System.out.println(className + "selectAll()");
		return service.selectAll();
	}
	
//	1개 출력
//	http://localhost:8081/faq/selectOne?id=
	@GetMapping("/selectOne")
	public @ResponseBody List<FaqVO> selectOne(FaqVO vo) {
		System.out.println(className + "selectOne()");
		return service.selectOne(vo);
	}
	
//	검색
//	http://localhost:8081/faq/search?cateId=&keyWord=
	@GetMapping("/search")
	public @ResponseBody List<FaqVO> search(FaqSearchVO svo) {
		System.out.println(className + "search()");
		return service.search(svo);
	}
	
	
	
//	Faq 등록
//	http://localhost:8081/faq/FaqWriter
	@GetMapping("/FaqWriter")
	public String FaqWriter() {
		return "admin_comu_FAQList_Write";
	}
	
//	http://localhost:8081/faq/insert
	@GetMapping("/insert")
	public @ResponseBody String insert(FaqVO vo) {
		System.out.println(className + "insert()" + vo.toString());
		return service.insert(vo).toString();
	}
	
//	Faq 수정
//	http://localhost:8081/faq/update
	@GetMapping("/update")
	public @ResponseBody String update(FaqVO vo) {
		System.out.println(className + "update()" + vo.toString());
		return service.update(vo).toString();
	}
	
//	Faq 삭제
//	http://localhost:8081/faq/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(FaqVO vo) {
		System.out.println(className + "delete()" + vo.toString());
		return service.delete(vo).toString();
	}

	
	// http://localhost:8081/faq/searchData
    @GetMapping("/searchData")
    public @ResponseBody Object getData4Toast3(FaqSearchVO svo) {
        System.out.println(className + ".getData4Toast3()");
        
        List<FaqVO> lstQnaResult = service.search(svo);
        return Libs.makeToastJsonResult(lstQnaResult);
    }
    
 // 기능 TOAST grid를 위한 검색 및 결과 작성	
    // http://localhost:8081/faq/toastSearch?cateId=&keyWord=
    @GetMapping("/toastSearch")
    public @ResponseBody JSONObject ToastSearch(FaqSearchVO svo) {
        System.out.println(className + ".faqToastSearch()");
        System.out.println(svo);
        return Libs.makeToastJsonResult(service.search(svo));  
    }
//    http://localhost:8081/faq/faqList
    @GetMapping("/faqList")
    public String faqList() {
    	return "admin_comu_FAQList";
    }
    
}

