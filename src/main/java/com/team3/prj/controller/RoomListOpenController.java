package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.team3.prj.etc.Common;

@Controller
public class RoomListOpenController {
    private final String className =  "RoomListOpenController";
    private final String className2 = className + ".";
    
    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "managerRsrvOpen1", Common.strRoleAMUY},  
        };
    }
    
    //화면 231번
  //http://localhost:8081/managerRsrvOpen1 
    @GetMapping("/managerRsrvOpen1")
    public String managerRsrvOpen1() {
        return "manager_Rsrv_open1";
    }
}
