package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.service.MainService;
import com.team3.prj.vo.CommonCodeVO;

@Controller
public class MainController {

	private final String className = "MainController";
    private final String className2 = className + ".";

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "mainMenu", Common.strRoleAMUY},
            {className2 + "header", Common.strRoleAMUY},
            {className2 + "footer", Common.strRoleAMUY},
            {className2 + "selectCommonCodes", Common.strRoleAMUY},
            {className2 + "getAccoCommonCode", Common.strRoleAMUY},
            {className2 + "getRoomCommonCode", Common.strRoleAMUY},
            {className2 + "getQnaCommonCode", Common.strRoleAMUY},
            {className2 + "leftSearch", Common.strRoleAMUY},
            {className2 + "leftMypage", Common.strRoleAMUY},
            {className2 + "leftComu", Common.strRoleAMUY},
            {className2 + "iContents", Common.strRoleAMUY}
        };
    }

	@Autowired
	MainService service;

	// http://localhost:8081/index
	@RequestMapping("/index")
	public String mainMenu() {
		return "index";
	}


    // http://localhost:8081/header
    @RequestMapping("/header")
    public String header() {
        return "header";
    }

    // http://localhost:8081/header
    @RequestMapping("/footer")
    public String footer() {
        return "footer";
    }

	// 기능: 공통코드 읽기
	// http://localhost:8081//main/selectCommonCodes
	// http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO
	// http://localhost:8081//main/selectCommonCodes?class1=ROOM&class2=TYPE_OF_ACCO&class3=resort
    @RequestMapping("/main/selectCommonCodes")
	public @ResponseBody List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo) {
		System.out.println(className + ".selectCommonCodes()");
		return service.selectCommonCodes(vo);
	}

	// 기능: 숙박시설 유형 공통코드 읽기
	// http://localhost:8081/main/getAccoCommonCode
    @RequestMapping("/main/getAccoCommonCode")
	public @ResponseBody List<CommonCodeVO> getAccoCommonCode() {
		System.out.println(className + ".getAccoCommonCode()");
		return service.selectCommonCodes(CommonCodeVO.createCommonCode("ROOM", "TYPE_OF_ACCO"));
	}

	// 기능: 룸 유형 공통코드 읽기
	// http://localhost:8081/main/getRoomCommonCode
    @RequestMapping("/main/getRoomCommonCode")
	public @ResponseBody List<CommonCodeVO> getRoomCommonCode() {
		System.out.println(className + ".getRoomCommonCode()");
		return service.selectCommonCodes(CommonCodeVO.createCommonCode("ROOM", "TYPE_OF_ROOM"));
	}

	// 기능: 질문유형(Q&A, FAQ) 유형 공통코드 읽기
	// http://localhost:8081/main/getQnaCommonCode
    @RequestMapping("/main/getQnaCommonCode")
	public @ResponseBody List<CommonCodeVO> getQnaCommonCode() {
		System.out.println(className + ".getQnaCommonCode()");
		return service.selectCommonCodes(CommonCodeVO.createCommonCode("QNA", "TYPE_OF_QNA"));
	}

	// 기능: leftSearch 화면출력
	// http://localhost:8081/main/leftSearch
	@RequestMapping("/main/leftSearch")
	public String leftSearch() {
		return "leftSearch";
	}

	// 기능: leftSearch 화면출력
	// http://localhost:8081/main/leftMypage
	@RequestMapping("/main/leftMypage")
	public String leftMypage() {
		return "leftMypage";
	}

	// 기능: leftSearch 화면출력
	// http://localhost:8081/main/leftCommu
	@RequestMapping("/main/leftCommu")
	public String leftComu() {
		return "leftCommu";
	}


	//기능: 메인 contents 출력
	// http://localhost:8081/main/iContents
	@RequestMapping("/main/iContents")
	public String iContents() {
		return "user_Main";
	}
}
