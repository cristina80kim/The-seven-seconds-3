package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 1st committing

@Controller
@RequestMapping("/test")
public class TestController {
    
    private final String className = "TestController";

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
    
    @GetMapping("/toggleCheckBox")
    public @ResponseBody String toggleCheckBox(
           // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub이 전달 안 된 경우 "N"을 가짐.
            String isPub, String name) {
    	isPub = isPub != null ? isPub : "N";
        System.out.println(className + ".frmToggleCheckBox(" + isPub + ", " + name + ")");
        return "상태 값 = " + isPub + ", 이름 = " + name;
    }
    
    
    
}
