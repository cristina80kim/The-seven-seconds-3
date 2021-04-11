package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.service.RsrvListService;
import com.team3.prj.vo.RsrvListVO;

@Controller
public class RsrvListController {
    private final String className = "RsrvListController";
    private final String className2 = className + ".";
    
    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "allrsrvlist", Common.strRoleAMUY},
            {className2 + "managerRsrvList", Common.strRoleAMUY},
            {className2 + "managerRsrvList/delete", Common.strRoleAMUY},
            {className2 + "managerRsrvList/update", Common.strRoleAMUY},
            {className2 + "managerRsrvList/rsrvCancel", Common.strRoleAMUY},
        };
    }
    
    
    
	@Autowired
	RsrvListService rsrvlistService;
	
	//http://localhost:8081/allrsrvlist
	@GetMapping("/allrsrvlist")
	public @ResponseBody List<RsrvListVO> selectAllRsrvList(){
		System.out.println("selectAllRsrvList()");
		List<RsrvListVO> lstRsrvList = rsrvlistService.selectAllRsrvList();
		return lstRsrvList;
	}
	
	// 230번 예약관리 예약리스트 (manager_RsrvList.html)
	//http://localhost:8081/managerRsrvList
	@GetMapping("/managerRsrvList")
	public String managerRsrvList() {
	    return "manager_RsrvList";
	}
	
	// 230번 예약관리 삭제 (manager_RsrvList.html)
	// http://localhost:8081/managerRsrvList/delete?id=
	@GetMapping("/managerRsrvList/delete")
	public @ResponseBody String delete(RsrvListVO vo) {
	    System.out.println(className + ".delete():" + vo.toString());
	    return rsrvlistService.delete(vo).toString();
	}
	
	//230번 예약관리 수정 (체크인,체크아웃,룸)
	// http://localhost:8081/managerRsrvList/update?checkIn=2021/04/05&checkOut=2021/04/10&rsrvRoom=아무거나&id=
	@GetMapping("/managerRsrvList/update")
	public @ResponseBody String update(RsrvListVO vo) {
	    System.out.println(className + ".update():" + vo.toString());
	    return rsrvlistService.update(vo).toString();
	}
	
	// 233번
	// http://localhost:8081/managerRsrvList/rsrvCancel
	@GetMapping("/managerRsrvList/rsrvCancel")
	public String rsrvCancel() {
	    return "manager_Rsrv_cancel";
	}
}
