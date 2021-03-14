package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.EmpService;
import com.team3.prj.vo.EmpVO;

@Controller
public class EmpController {
   
   @Autowired
   EmpService empService;

   // http://localhost:8081/allEmps
   @GetMapping("/allEmps")
   public @ResponseBody List<EmpVO> selectAllEmps() {
      System.out.println("selectAllEmps()");
      List<EmpVO> lstEmps = empService.selectAllEmps();
      return lstEmps;
   }
}
