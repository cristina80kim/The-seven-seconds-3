package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 4 test committing.... 3nd

@Controller
@RequestMapping("/test")
public class TestController {
    
    private final String className = "TestController";

    // http://localhost:8081/test/frmShowGrid
    @GetMapping("/frmShowGrid")
    public String frmShowGrid() {
        System.out.println(className + ".frmShowGrid()");
        return "frmTestShowGrid";  // .html
    }
}
