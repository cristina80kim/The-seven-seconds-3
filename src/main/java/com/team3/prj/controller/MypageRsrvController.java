package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.MypageRsrvService;
import com.team3.prj.vo.MypageRsrvVO;


@Controller
@RequestMapping("/mypage")
public class MypageRsrvController {
	private final String className = "MypageRsrvController";
	@Autowired
	MypageRsrvService mypagersrvService;
	
	//http://localhost:8081/mypage/allmypagersrv
	@GetMapping("/allmypagersrv")
	public @ResponseBody List<MypageRsrvVO> selectAllMypage(){
	System.out.println("selectAllMypage()");
	List<MypageRsrvVO> lstMypage = mypagersrvService.selectAllMypage();
	return lstMypage;
	}
	//예약 삭제
	//http://localhost:8081/mypage/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(MypageRsrvVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return mypagersrvService.delete(vo).toString();
	}
	
}