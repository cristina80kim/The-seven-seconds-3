package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.service.MypageRsrvService;
import com.team3.prj.vo.MypageRsrvVO;


@Controller
@RequestMapping("/mypage")
public class MypageRsrvController {
	private final String className = "MypageRsrvController";
	private final String className2 = className + ".";
	
	public String[][] getAuthorizations() {
		return new String[][] {
			{className2 + "allmypagersrv", Common.strRoleAMUY},
			{className2 + "mypagersrv", Common.strRoleAMUY},
			{className2 + "delete", Common.strRoleAMUY},
		};
	}
	
	@Autowired
	MypageRsrvService mypagersrvService;
	
	//http://localhost:8081/mypage/allmypagersrv
	//출력
	@GetMapping("/allmypagersrv")
	public @ResponseBody List<MypageRsrvVO> selectAllMypage(){
	    System.out.println(className + ".selectAllMypage()");
	    return mypagersrvService.selectAllMypage();
	}
	
	//페이지 130번
	//http://localhost:8081/mypage/mypagersrv
	@GetMapping("/mypagersrv")
	public String mypagersrv() {
	    return "user_MypageRsrv";
	}
	
	//예약 삭제
	//http://localhost:8081/mypage/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(MypageRsrvVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return mypagersrvService.delete(vo).toString();
	}
	
}