package com.team3.prj.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Libs;
import com.team3.prj.service.NoticeService;
import com.team3.prj.vo.NoticeSearchVO;
import com.team3.prj.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private final String className = "NotiController";

	@Autowired
	NoticeService service;

//	전체출력
//	http://localhost:8081/notice/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<NoticeVO> selectAll() {
		System.out.println(className + "selectAll()");
		return service.selectAll();
	}
	
//	1개 출력
//	http://localhost:8081/notice/selectOne?id=
	@GetMapping("/selectOne")
	public @ResponseBody List<NoticeVO> selectOne(NoticeVO vo){
		System.out.println(className + "selectOne()");
		return service.selectOne(vo);
	}
	
//	검색기능
//	http://localhost:8081/notice/search?keyWord=
	@GetMapping("/search")
	public @ResponseBody List<NoticeVO> search(NoticeSearchVO svo){
		System.out.println(className + "search()");
		return service.search(svo);
	}
	
//	공지사항 등록
//	http://localhost:8081/notice/insertNotice
	@GetMapping("insertNotice")
	public String insertNotice() {
		return "admin_comu_NotiList_Write";//.html
	}
	
//	http://localhost:8081/noti/insert
	@GetMapping("/insert")
	public @ResponseBody String insert(NoticeVO vo) {
		System.out.println(className + "insert()" + vo.toString());
		return service.insert(vo).toString();
	}
	
	
//	공지사항 수정
//	http://localhost:8081/notice/update?title= &content= &id= 
	@GetMapping("/update")
	public @ResponseBody String update(NoticeVO vo) {
		System.out.println(className + "update()" + vo.toString());
		return service.update(vo).toString();
	}
	
	
//	공지사항 삭제
//	http://localhost:8081/notice/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(NoticeVO vo) {
		System.out.println(className + "delete()" + vo.toString());
		return service.delete(vo).toString();
	}
	
	// http://localhost:8081/notice/searchData
		@GetMapping("/searchData")
		public @ResponseBody Object getDataToast(NoticeSearchVO svo) {
			System.out.println(className + ".getDataToast()");

			List<NoticeVO> lstQnaResult = service.search(svo);
			return Libs.makeToastJsonResult(lstQnaResult);
		}
		
		// http://localhost:8081/notice/toastSearch?cateId=&keyWord=
		@GetMapping("/toastSearch")
		public @ResponseBody JSONObject ToastSearch(NoticeSearchVO svo) {
			System.out.println(className + ".NoticeToastSearch()");
			System.out.println(svo);
			return Libs.makeToastJsonResult(service.search(svo));
		}
		
//	    http://localhost:8081/notice/adminList
		@GetMapping("/adminList")
		public String adminList() {
			return "admin_comu_NotiList";
		}
		
	//  http://localhost:8081/notice/searchList
		   @GetMapping("/searchList")
		   public String userList() {
		      return "user_ComuNoti";

		   }
}
