package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.UserService;
import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private final String className = "UserController";
	
	@Autowired
	UserService userService;
	
	//http://localhost:8081/user/userAll
	@GetMapping("/userAll")
	public @ResponseBody List<UserVO> selectAll() {
		System.out.println("selectAll()");
		List<UserVO> lstUser = userService.selectAll();
		return lstUser;
	}
	
	//http://localhost:8081/user/frmLogin
	@GetMapping("/frmLogin")
	public String frmLogin() {
		System.out.println(className + ".frmLogin");
		return "user_Login"; //user_Login.html
	}
	
	@GetMapping("/login")
	public @ResponseBody UserVO login(UserVO vo) {
		System.out.println(className + ".login()");
		System.out.println(vo);
		return userService.login(vo);
	}
	
	//http://localhost:8081/user/frmJoin
	@GetMapping("/frmJoin")
	public String frmJoin() {
		System.out.println(className + ".frmJoin()");
		return "user_Join";// user_Join.html
	}
	
	@PostMapping("/join")
	public @ResponseBody String join(@RequestBody UserVO vo) {
		System.out.println(className + ".join()");
		System.out.println(vo);
		return userService.join(vo);
	}
	
	//http://localhost:8081/user/frmMypage
	//마이페이지 메인
	@GetMapping("mypage")
	public @ResponseBody UserVO mypage(UserVO vo) {
		System.out.println(className + ".mypage");
		return userService.login(vo);
	}
	
	//http://localhost:8081/user/frmUpdate
	@GetMapping("frmUpdate")
	public String frmUpdate() {
		System.out.println(className + ".frmUpdate");
		return "user_Mypage_M_Info";
	}
	
	//http://localhost:8081/user/update?pwd=&nickname=&tel=&email=&id=
	@GetMapping("update")
	public @ResponseBody String update(UserVO vo) {
		System.out.println(className + ".update()");
		System.out.println(vo);
		return userService.update(vo);
	}
	
	//http://localhost:8081/user/delete?id=&pwd=
	@GetMapping("delete")
	public @ResponseBody Long delete(UserVO vo) {
		System.out.println(className + ".delete()");
		System.out.println(vo);
		return userService.delete(vo);
	}
	
	// Manage 내정보수정
	// http://localhost:8081/user/mUpdate?pwd=&nickname=&tel=&email=&id=
	@GetMapping("mUpdate")
	public @ResponseBody String mupdate(UserVO vo) {
		System.out.println(className + ".mUpdate()");
		System.out.println(vo);
		return userService.mUpdate(vo);
	}
	
	// User 후기
	// http://localhost:8081/user/revu
	@GetMapping("revu")
	public @ResponseBody List<RevuVO> revu() {
		System.out.println(className + ".revu()");
		List<RevuVO> lstRevu = userService.revu();
		return lstRevu;
	}
	
	// User 후기 삭제
	// http://localhost:8081/user/revuDelete?id=시퀀스값
	@GetMapping("revuDelete")
	public @ResponseBody Long revuDelete(RevuVO vo) {
		return userService.revuDelete(vo);
	}
	
}

