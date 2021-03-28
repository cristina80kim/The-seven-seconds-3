package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.UserService;
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/User")
public class UserController {
	private final String className = "UserController";
	
	@Autowired
	UserService userservice;
	
	//http://localhost:8081/User/userAll
	@GetMapping("/userAll")
	public @ResponseBody List<UserVO> selectAll() {
		System.out.println("selectAll()");
		List<UserVO> lstUser = userservice.selectAll();
		return lstUser;
	}
	
	//http://localhost:8081/User/frmLogin
	@GetMapping("/frmLogin")
	public String frmLogin() {
		System.out.println(className + ".frmLogin");
		return "user_Login"; //user_Login.html
	}
	

	//http://localhost:8081/User/login
	@GetMapping("/login")
	public @ResponseBody UserVO login(UserVO vo) {
		System.out.println(className + ".login()");
		System.out.println(vo);
		return userservice.login(vo);
	}
	/*
	 * public String login(String id, String pw, HttpSession session) {
	 * HashMap<String, String> map = new HashMap<String, String>();
	 * 
	 * map.put("id", id); map.put("pw", pw); UserVO vo = userservice.login(map);
	 * session.setAttribute("user_Login", vo); return ; }
	 */
	
	@GetMapping("/join")
	public @ResponseBody String join(UserVO vo) {
		System.out.println(className + ".join" + vo.toString());
		return userservice.join(vo).toString();
	}
	
}