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

    // 기능: 공통코드 읽기
    // http://localhost:8081//main/selectCommonCodes
    // http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO
    // http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO&class3=resort
    @GetMapping("/main/selectCommonCodes")
    public @ResponseBody List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo) {
        System.out.println(className + ".selectCommonCodes()");
        return service.selectCommonCodes(vo);
    }
    
    // 기능: 숙박시설 유형 공통코드 읽기
    // http://localhost:8081//main/getAccmCommonCode
    @GetMapping("/main/getAccmCommonCode")
    public @ResponseBody List<CommonCodeVO> getAccmCommonCode() {
        System.out.println(className + ".getAccmCommonCode()");
        return service.selectCommonCodes(CommonCodeVO.createCommonCode("ROOM", "TYPE_OF_ACCO"));
    }
    
    // 기능: 룸 유형 공통코드 읽기
    // http://localhost:8081//main/getRoomCommonCode
    @GetMapping("/main/getRoomCommonCode")
    public @ResponseBody List<CommonCodeVO> getRoomCommonCode() {
        System.out.println(className + ".getRoomCommonCode()");
        return service.selectCommonCodes(CommonCodeVO.createCommonCode("ROOM", "TYPE_OF_ROOM"));
    }
    
    // 기능: 질문유형(Q&A, FAQ) 유형 공통코드 읽기
    // http://localhost:8081//main/getQnaCommonCode 
    @GetMapping("/main/getQnaCommonCode")
    public @ResponseBody List<CommonCodeVO> getQnaCommonCode() {
        System.out.println(className + ".getQnaCommonCode()");
        return service.selectCommonCodes(CommonCodeVO.createCommonCode("QNA", "TYPE_OF_QNA"));
    }
    
}
