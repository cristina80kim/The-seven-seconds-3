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
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/User")
public class UserController {
	private final String className = "UserController";
	
	@Autowired
	UserService userService;
	
	//http://localhost:8081/User/userAll
	@GetMapping("/userAll")
	public @ResponseBody List<UserVO> selectAll() {
		System.out.println("selectAll()");
		List<UserVO> lstUser = userService.selectAll();
		return lstUser;
	}
	
	//http://localhost:8081/User/frmLogin
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
	
	
	//http://localhost:8081/User/frmJoin
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
	
	//http://localhost:8081/User/frmMypage
	@GetMapping("frmMypage")
	public String frmMypage() {
		System.out.println(className + ".frmMypage");
		return "user_Main";
	}
	
	//http://localhost:8081/User/frmUpdate
	@GetMapping("frmUpdate")
	public String frmUpdate() {
		System.out.println(className + ".frmUpdate");
		return "user_Mypage_M_Info";
	}
	
	//http://localhost:8081/User/Update?pwd=&nickname=&tel=&email=&id=
	@GetMapping("Update")
	public @ResponseBody String update(UserVO vo) {
		System.out.println(className + ".update()");
		System.out.println(vo);
		return userService.update(vo);
	}
	
	//http://localhost:8081/User/Delete?id=&pwd=
	@GetMapping("Delete")
	public @ResponseBody Long delete(UserVO vo) {
		System.out.println(className + ".delete()");
		System.out.println(vo);
		return userService.delete(vo);
	}
}








