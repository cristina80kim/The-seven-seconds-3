package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Libs;
import com.team3.prj.vo.AjaxTestVO;
import com.team3.prj.vo.EmpVO;

import lombok.NoArgsConstructor;

// 1st committing

@Controller
@RequestMapping("/test")
public class TestController {
    
    private final String className = "TestController";

    // http://localhost:8081/test/json
    @GetMapping("/jsonTest")
    @ResponseBody()
    public EmpVO jsonTest() {
        System.out.println(className + ".jsonTest()");
        return new EmpVO();
    }
    
    // http://localhost:8081/test/frmShowGrid
    @GetMapping("/frmShowGrid")
    public String frmShowGrid() {
        System.out.println(className + ".frmShowGrid()");
        return "test/frmTestShowGrid";  // .html
    }
    
    // http://localhost:8081/test/frmToggleCheckBox
    @GetMapping("/frmToggleCheckBox")
    public String frmToggleCheckBox() {
        System.out.println(className + ".frmToggleCheckBox()");
        return "test/frmToggleCheckBox";  // .html
    }
    
    
    @PostMapping("/toggleCheckBox")
    public @ResponseBody AjaxTestVO toggleCheckBox(
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub이 전달 안 된 경우 "N"을 가짐.
            // String isPub, String name, String age, String tel) {
            AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");
        
        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null 또는 "" 인 경우 "N"으로 변경
        }
        
        System.out.println("[상태값] " + vo);
        return vo;
    }
    
    // ************************************************
    // * JSON 데이터를 parameter로 전달하는  경우
    //   - POST 방식, 
    //   - P@RequestBody로 parameter 받고,
    //   - Parameter VO에 @NoArgsConstructor
    //   가 있어야 한다.
    // ************************************************
    @PostMapping("/ajaxToggleCheckBox")
    public @ResponseBody AjaxTestVO ajaxToggleCheckBox(
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub이 전달 안 된 경우 "N"을 가짐.
            // String isPub, String name, String age, String tel) {
            @RequestBody AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");
        
        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null 또는 "" 인 경우 "N"으로 변경
        }
        
        System.out.println("[상태값] " + vo);
        return vo;
    }

}
