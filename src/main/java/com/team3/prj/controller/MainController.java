package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.MainService;
import com.team3.prj.vo.CommonCodeVO;

@Controller
public class MainController {
    
    private final String className = "MainController";
    
    @Autowired
    MainService service;

	// http://localhost:8081/index
    @RequestMapping("/index")
	public String mainMenu() {
        return "index";
	}
	
    // http://localhost:8081//main/selectCommonCodes
    // http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO
    // http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO&class3=resort
    @GetMapping("/main/selectCommonCodes")
    public @ResponseBody List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo) {
        System.out.println(className + ".selectCommonCodes()");
        return service.selectCommonCodes(vo);
    }
    
}
