package com.team3.prj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team3.prj.service.UserService;
import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private final String className = "UserController";

	@Autowired
	UserService userService;

	// http://localhost:8081/user/frmLogin
	@GetMapping("/frmLogin")
	public String frmLogin() {
		System.out.println(className + ".frmLogin");
		return "user_Login"; // user_Login.html
	}

	@GetMapping("/login")
	public @ResponseBody UserVO login(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) {
		System.out.println(className + ".frmLogin");
		HttpSession session = req.getSession();
		UserVO result = userService.login(vo);

//		if (id == null) {
//			session.setAttribute("id", null);
//			rttr.addFlashAttribute("msg", false);
//		} else {
//			session.setAttribute("id", id);
//		}
		System.out.println(result);
		return result;
	}

	// http://localhost:8081/user/frmJoin
	@GetMapping("/frmJoin")
	public String frmJoin() {
		System.out.println(className + ".frmJoin()");
		return "user_Join";// user_Join.html
	}
	
	@PostMapping("/join")
	public @ResponseBody String join(UserVO vo) throws Exception {
		System.out.println(className + ".join()");
		 int count = userService.idCheck(vo.getId());
	        
	        try {
	            if(count == 1) userService.join(vo); 
	            System.out.println("확인용");
	            System.out.println(vo);
	        } catch (Exception e) {
	                System.out.println("아이디가 존재합니다.");
	        }
	        return userService.join(vo);
	}
	
    @PostMapping
    public @ResponseBody int IdCheck(String id) throws Exception {
        
    	System.out.println(className + ".idCheck");
		if (userService.idCheck(id) == 1) {
			return 1;
		} else {
			return 0;
		}  
    }
	
//	@PostMapping("/join")
//	public @ResponseBody String join(UserVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println(className + ".join()");
//        String role = request.getParameter("role");
//        String id = request.getParameter("id");
//        String pwd = request.getParameter("pwd");
//        String pwdChk = request.getParameter("pwdChk");
//        String name = request.getParameter("name");
//        String tel = request.getParameter("tel");
//        String email = request.getParameter("email");
//        String gen = request.getParameter("gen");
//        
//        System.out.println(vo);
//        System.out.println("확인용");
//        
//        if (pwd.equals(pwdChk)) {
//        	vo.setNickname(" ");
//        	vo.setCUser(" ");
//        	
//        	if(role.equals("개인"))
//        		vo.setRole("U");
//        	else if(role.equals("사장"))
//        		vo.setRole("M");
//        	
//        	if(gen.equals("남"))
//        		vo.setGen("M");
//        	if(gen.equals("여"))
//        		vo.setGen("F");
//        	
//        	vo.setId(id);
//        	vo.setPwd(pwd);
//        	vo.setName(name);
//        	vo.setTel(tel);
//        	vo.setEmail(email);
//        	
//        } else {
//        	PrintWriter prt = response.getWriter();
//        	prt.println("<script>alert('패스워드를 다시 확인해주세요');history.go(-1);</script>");
//        	prt.flush();
//        }
//        
//        if(userService.checkId(id) == 1) {
//        	PrintWriter out = response.getWriter();
//        	out.println("<script>alert('사용중인 아이디입니다.'); history.go(-1);</script>");
//        	out.flush();
//        }
//        
//		return userService.join(vo);
//	}
	
//	@ResponseBody
//	@PostMapping("/checkId")
//	public int checkId(String id) throws Exception{
//		System.out.println(className + ".checkId");
//		if (userService.checkId(id) == 1) {
//			return 1;
//		} else {
//			return 0;
//		}
//	}

//	@PostMapping("/join")
//	public @ResponseBody String join(@RequestBody UserVO vo) {
//		System.out.println(className + ".join()");
//		System.out.println(vo);
//		return userService.join(vo);
//	}

	// http://localhost:8081/user/frmMypage
	// 마이페이지 메인
	@GetMapping("frmMypage")
	public String frmMypage() {
		System.out.println(className + ".frmMypage");
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
		UserVO curvo = new UserVO();
		curvo.setId("shseong"); // 로그인manager에서 불러옴
		httpSession.setAttribute("userId", curvo.getId());
		return "user_MypageMain"; // user_MypageMain.html
	}

	@GetMapping("mypage")
	public @ResponseBody UserVO mypage(UserVO vo) {
		System.out.println(className + ".mypage");
		return userService.login(vo);
	}

	// http://localhost:8081/user/frmUpdate
	@GetMapping("frmUpdate")
	public String frmUpdate() {
		System.out.println(className + ".frmUpdate");
		return "user_Mypage_M_Info";
	}

	// http://localhost:8081/user/update?pwd=&nickname=&tel=&email=&id=
	@GetMapping("update")
	public @ResponseBody String update(UserVO vo) {
		System.out.println(className + ".update()");
		System.out.println(vo);
		return userService.update(vo);
	}

	// http://localhost:8081/user/delete?id=&pwd=
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

	// admin 회원리스트
	// http://localhost:8081/user/userAll
	@GetMapping("/userAll")
	public @ResponseBody List<UserVO> selectAll() {
		System.out.println("selectAll()");
		List<UserVO> lstUser = userService.selectAll();
		return lstUser;
	}

}