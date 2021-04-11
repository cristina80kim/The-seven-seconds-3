package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.service.StayListService;
import com.team3.prj.vo.StayListSearchResultVO;
import com.team3.prj.vo.StayListSearchVO;
import com.team3.prj.vo.StayListSearchVO2;
import com.team3.prj.vo.StayListVO;

@Controller
@RequestMapping("/staylist")
public class StayListController {
private final String className="StayListController";
private final String className2 = className + ".";

public String[][] getAuthorizations() {
    return new String[][] {
        {className2 + "listall", Common.strRoleAMUY},
        {className2 + "userRoomList", Common.strRoleAMUY},
        {className2 + "userRoomList2", Common.strRoleAMUY},
    };
}


    @Autowired
    StayListService stayService;

    //http://localhost:8081/staylist/listall
    @GetMapping("/listall")
    public @ResponseBody List<StayListVO> StayListAll() {
        System.out.println(className+".StayListAll()");
        return stayService.StayListAll();
    }

    //http://localhost:8081/staylist/userRoomList
    @PostMapping("/userRoomList")
    public String userRoomList (@RequestBody StayListSearchVO vo) {
        System.out.println(className+".userRoomList()");
        System.out.println(vo);

        StayListSearchVO2 vo2 = new StayListSearchVO2(vo);
        System.out.println(vo2);

        List<StayListSearchResultVO> result = stayService.search(vo2);
//        new ListToString().print(result);

        return "user_RoomList";
}
    //131번 페이지연결
    //http://localhost:8081/staylist/userRoomList2
    @GetMapping("/userRoomList2")
    public String userRoomList2() {
        return "user_RoomList";
    }
}
