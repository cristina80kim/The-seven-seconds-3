package com.team3.prj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.team3.prj.etc.Common;
import com.team3.prj.etc.Libs;
import com.team3.prj.service.NoticeService;
import com.team3.prj.vo.NoticeSearchVO;
import com.team3.prj.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private final String className = "NotiController";
    private final String className2 = className + ".";

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "selectAll", Common.strRoleAMUY},
            {className2 + "selectOne", Common.strRoleAMUY},
            {className2 + "search", Common.strRoleAMUY},
            {className2 + "insertNotice", Common.strRoleAMUY},
            {className2 + "insert", Common.strRoleAMUY},
            {className2 + "update", Common.strRoleAMUY},
            {className2 + "delete", Common.strRoleAMUY},
            {className2 + "searchData", Common.strRoleAMUY},
            {className2 + "toastSearch", Common.strRoleAMUY},
            {className2 + "adminList", Common.strRoleAMUY},
            {className2 + "searchList", Common.strRoleAMUY},
            {className2 + "userNoti", Common.strRoleAMUY},
           
        };
    }
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
	@RequestMapping("/selectOne")
	public @ResponseBody List<NoticeVO> selectOne(@RequestBody NoticeVO vo) {
		System.out.println(className + "selectOne()");
		System.out.println("입력 : " + vo);
		List<NoticeVO> result = service.selectOne(vo);
		System.out.println("출력 : " + result);
		return result;
	}

//	검색기능
//	http://localhost:8081/notice/search?keyWord=
	@GetMapping("/search")
	public @ResponseBody List<NoticeVO> search(NoticeSearchVO svo) {
		System.out.println(className + "search()");
		return service.search(svo);
	}

//	공지사항 등록
//	http://localhost:8081/notice/insertNotice
	@GetMapping("insertNotice")
	public String insertNotice() {
		return "admin_comu_NotiList_Write";// .html
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

	// http://localhost:8081/notice/searchList
	@GetMapping("/searchList")
	public String userList() {
		return "user_ComuNoti";

	}

	// http://localhost:8081/notice/userNoti
	@GetMapping("/userNoti")
	public String userNoti(String id) {
		ServletRequestAttributes servletRequestAttribute =
				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
		
		httpSession.setAttribute("id", id);

		return "user_noti";

//		UserVO curvo = new UserVO();
//		curvo.setId("shseong"); // 로그인manager에서 불러옴
//		httpSession.setAttribute("userId", curvo.getId());
//		return "user_MypageMain";
		
	}
	
//	@GetMapping("/testNoti")
//	public String testNoti(String id) {
//		ServletRequestAttributes servletRequestAttribute =
//				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		
//		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
//		List<NoticeVO> result = service.selectOne(id);
//		httpSession.setAttribute("result", result);
//		
//		return "user_noti";
//	}

}
