package com.team3.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomListOpenController {

    //화면 231번
  //http://localhost:8081/managerRsrvOpen1 
    @GetMapping("/managerRsrvOpen1")
    public String managerRsrvOpen1() {
        return "manager_Rsrv_open1";
    }
}
