package com.team3.prj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.team3.prj.etc.Common;
import com.team3.prj.etc.Libs;
import com.team3.prj.etc.LoginManager;
import com.team3.prj.service.UserService;
import com.team3.prj.vo.ExecResultVO;
import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserInstanceVO;
import com.team3.prj.vo.UserSearchVO;
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private final String className = "UserController";
	private final String className2 = className + ".";
	
	public String[][] getAuthorizations() {
		return new String[][] {
			{className2 + "frmLogin", Common.strRoleAMUY},
			{className2 + "login", Common.strRoleAMUY},
			{className2 + "frmJoin", Common.strRoleAMUY},
			{className2 + "join", Common.strRoleAMUY},
			{className2 + "frmMypage", Common.strRoleAMUY},
			{className2 + "mypage", Common.strRoleAMUY},
			{className2 + "frmUpdate", Common.strRoleAMUY},
			{className2 + "update", Common.strRoleAMUY},
			{className2 + "uDelete", Common.strRoleAMUY},
			{className2 + "delete", Common.strRoleAMUY},
			{className2 + "frmMUpdate", Common.strRoleAMUY},
			{className2 + "mUpdate", Common.strRoleAMUY},
			{className2 + "uRevu", Common.strRoleAMUY},
			{className2 + "revu", Common.strRoleAMUY},
			{className2 + "revuDelete", Common.strRoleAMUY},
			{className2 + "frmUserAll", Common.strRoleAMUY},
			{className2 + "toastSearch", Common.strRoleAMUY},
			{className2 + "toastUserSearch", Common.strRoleAMUY},
			{className2 + "userPoint", Common.strRoleAMUY},
			{className2 + "userBookmark", Common.strRoleAMUY},
		};
	}

	@Autowired
	UserService userService;

	// 로그인
	// http://localhost:8081/user/frmLogin
	@GetMapping("/frmLogin")
	public String frmLogin() {
		System.out.println(className + ".frmLogin");
		return "user_Login"; // user_Login.html
	}

	@GetMapping("/login")
	public @ResponseBody UserVO login(UserVO vo) {
		System.out.println(className + ".frmLogin");
		UserVO result = userService.login(vo);
		System.out.println(result);
		return result;
	}

	// 회원가입
	// http://localhost:8081/user/frmJoin
	@GetMapping("/frmJoin")
	public String frmJoin() {
		System.out.println(className + ".frmJoin()");
		return "user_Join";// user_Join.html
	}

	@PostMapping("/join")
	public @ResponseBody ExecResultVO join(@RequestBody UserVO vo) {
		System.out.println(className + ".join()");
		System.out.println(vo);
		String result = userService.join(vo);
		System.out.println(result);
		// #####json으로 리턴할때는 String이 아닌 VO클래스를 하나 만들어서 결과를 응답해야만 한다.
		return new ExecResultVO(result);
	}

	// 아이디 중복확인
	@RequestMapping("/checkDuplId")
	public @ResponseBody int checkDuplId(@RequestBody UserVO vo) throws Exception {
		System.out.println(className + ".checkDuplId");
		return userService.checkDuplId(vo.getId());
	}

	// http://localhost:8081/user/frmMypage
	// 마이페이지 메인
	@RequestMapping("frmMypage")
	public String frmMypage() {
		System.out.println(className + ".frmMypage");
//		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder
//				.currentRequestAttributes();
//		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
//		UserVO curvo = new UserVO();
//		curvo.setId("shseong"); // 로그인manager에서 불러옴
		UserInstanceVO vo = LoginManager.getUserInfo();
		System.out.println("user vo: " + vo);
		String userId = LoginManager.getUserId();
		Libs.setSessionAttribute("id", userId);
		System.out.println("확인 아이디: " + userId);
		return "user_MypageMain"; // user_MypageMain.html
	}

	@RequestMapping("mypage")
	public @ResponseBody UserVO mypage(@RequestBody UserVO vo) {
		System.out.println(className + ".frmLogin");
		System.out.println(vo);
		UserVO result = userService.myMain(vo);
		System.out.println(result);
		return result;
	}


	// 마이페이지 수정
	// http://localhost:8081/user/frmUpdate
	@RequestMapping("frmUpdate")
	public String frmUpdate() {
		System.out.println(className + ".frmUpdate");
		UserInstanceVO vo = LoginManager.getUserInfo();
		String userId = LoginManager.getUserId();
		Libs.setSessionAttribute("id", userId);
		System.out.println("수정할 유저 아이디: " + userId);
		return "user_Mypage_M_Info"; // .html
	}

	// http://localhost:8081/user/update?pwd=&nickname=&tel=&email=&id=
	@RequestMapping("update")
	public @ResponseBody ExecResultVO update(@RequestBody UserVO vo) {
		System.out.println(className + ".udpate()");
		System.out.println(vo);
		String result = userService.update(vo);
		System.out.println(result);
		return new ExecResultVO(result);
	}

	// 회원탈퇴
	// http://localhost:8081/user/uDelete
	@RequestMapping("/uDelete")
	public String uDelete() {
		System.out.println(className + ".uDelete()");
		UserInstanceVO vo = LoginManager.getUserInfo();
		System.out.println("user vo: " + vo);
		String userId = LoginManager.getUserId(); // 로그인된 id를 읽음.
		Libs.setSessionAttribute("id", userId);
		System.out.println("삭제할 유저 아이디: " + userId);
		return "user_Mypage_Sec"; // .html
	}

	// http://localhost:8081/user/delete?id=&pwd=
	@RequestMapping("delete")
	public @ResponseBody ExecResultVO delete(@RequestBody UserVO vo) {
		System.out.println(className + ".delete()");
		System.out.println(vo);
		int result = userService.delete(vo);
		System.out.println(result);
		return new ExecResultVO(result);
	}

	// Manage 내정보수정
	// http://localhost:8081/user/frmMUpdate
	@RequestMapping("frmMUpdate")
	public String frmMUpdate() {
		System.out.println(className + ".frmMUpdate");
		return "manager_Mypage_M_info"; // .html
	}

	@RequestMapping("mUpdate")
	public @ResponseBody ExecResultVO mupdate(@RequestBody UserVO vo) {
		System.out.println(className + ".mUpdate()");
		System.out.println(vo);
		String result = userService.mUpdate(vo);
		System.out.println(result);
		return new ExecResultVO(result);
	}

	// 후기 관리
	// http://localhost:8081/user/uRevu
	@GetMapping("/uRevu")
	public String userRevu() {
		System.out.println(className + ".uRevu()");
		return "user_MypageRevu"; // .html
	}

	@GetMapping("revu")
	public @ResponseBody Object revu(RevuVO vo) {
		System.out.println(className + ".revu()");
		List<RevuVO> lstRevu = userService.revu();
		return Libs.makeToastJsonResult(lstRevu);
	}

	// User 후기 삭제
	// http://localhost:8081/user/revuDelete?id=시퀀스값
	@GetMapping("revuDelete")
	public @ResponseBody Long revuDelete(RevuVO vo) {
		return userService.revuDelete(vo);
	}

	// admin 회원리스트
	// http://localhost:8081/user/frmUserAll
	@GetMapping("frmUserAll")
	public String frmUserALl() {
		System.out.println(className + ".frmUserAll()");
		return "admin_memberList"; // .html
	}

	@GetMapping("/userAll")
	public @ResponseBody Object userAll() {
		System.out.println("selectAll()");
		List<UserVO> lstUser = userService.userAll();
		return Libs.makeToastJsonResult(lstUser);
	}

	// admin 회원리스트 검색기능
	// http://localhost:8081/user/toastSearch
	@GetMapping("/toastSearch")
	public @ResponseBody JSONObject ToastSearch() {
		System.out.println(className + ".UserSearchVO()");
		//System.out.println(svo);
		UserSearchVO svo = new UserSearchVO();
		List<UserVO> result = userService.userSearch(svo);
		System.out.println(result);
		return Libs.makeToastJsonResult(result);
	}

	@GetMapping("/toastUserSearch")
	public @ResponseBody Object getData4Toast3(UserSearchVO svo) {
		System.out.println(className + ".getData4Toast3()");
		List<UserVO> result = userService.userSearch(svo);
		return Libs.makeToastJsonResult(result);
	}

//	@GetMapping("/searchData")
//	public @ResponseBody Object getDataToast(UserSearchVO svo) {
//		System.out.println(className + "searchData()");
//		List<UserVO> result = userService.userSearch(svo);
//		return Libs.makeToastJsonResult(result);
//	}

	// 포인트 관리
	// http://localhost:8081/user/userPoint
	@GetMapping("/userPoint")
	public String userPoint() {
		return "user_MypagePoint";
	}

	// 즐겨찾기
	// http://localhost:8081/user/userBookmark
	@GetMapping("/userBookmark")
	public String userBookmark() {
		return "user_MypageBookMark";
	}


}