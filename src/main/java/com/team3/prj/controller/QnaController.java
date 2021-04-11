package com.team3.prj.controller;

import java.util.List;

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
import com.team3.prj.service.QnaService;
import com.team3.prj.vo.FaqSearchVO;
import com.team3.prj.vo.FaqVO;
import com.team3.prj.vo.QnaSearchVO;
import com.team3.prj.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	private final String className = "QnaController";
    private final String className2 = className + ".";

    public String[][] getAuthorizations() {
        return new String[][] {
            
        	{className2 + "frmSelectAll", Common.strRoleAMUY},        	
        	{className2 + "selectAll", Common.strRoleAMUY},        	
        	{className2 + "oneSelect", Common.strRoleAMUY},        	
        	{className2 + "search", Common.strRoleAMUY},
        	{className2 + "toastSearch", Common.strRoleAMUY},
            {className2 + "qWriter", Common.strRoleAUY},            
            {className2 + "insert", Common.strRoleAUY},            
            {className2 + "qUpdate", Common.strRoleAUY},            
            {className2 + "updateQ", Common.strRoleAUY},            
            {className2 + "aWriter", Common.strRoleAUY},            
            {className2 + "updateA", Common.strRoleAUY},            
            {className2 + "delete", Common.strRoleAUY},            
            {className2 + "searchData", Common.strRoleAUY},            
            {className2 + "adminList", Common.strRoleAUY},            
            {className2 + "userList", Common.strRoleAUY},
            {className2 + "userQna", Common.strRoleAUY},
            {className2 + "selectCnt", Common.strRoleAUY},
            
        };
    }
	
	@Autowired
	QnaService service;

	// http://localhost:8081/qna/frmSelectAll 
	@GetMapping("/frmSelectAll")
	public String frmSelectAll() {
		System.out.println(className + ".frmSelectAll()");
		return "user_ComuQnAList"; // .html
	}

	// http://localhost:8081/qna/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<QnaVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

//	http://localhost:8081/qna/oneSelect?id=1000000001
	@RequestMapping("/oneSelect")
	public @ResponseBody List<QnaVO> selectOne(@RequestBody QnaVO vo) {
		System.out.println(className + "selectOne()");
		System.out.println("입력 : " + vo);
		List<QnaVO> result = service.selectOne(vo);
		System.out.println("출력 : " + result);
		return result;
	}
	
	// 기능 : Qna 목록 검색
	// param : QnaSearchVO중 - cateIdValue(카테고리 값),searchType(제목,닉네임),keyWord(검색어)
	// http://localhost:8081/qna/search?cateId=&keyWord=
	@GetMapping("/search")
	public @ResponseBody List<QnaVO> qnaSearch(QnaSearchVO svo) {
		System.out.println(className + ".search()");
        System.out.println(svo);
		return service.search(svo);
	}
	
	// 기능 TOAST grid를 위한 검색 및 결과 작성	
    // http://localhost:8081/qna/toastSearch?cateId=&keyWord=
    @GetMapping("/toastSearch")
    public @ResponseBody JSONObject qnaToastSearch(QnaSearchVO svo) {
        System.out.println(className + ".qnaToastSearch()");
        System.out.println(svo);
        List<QnaVO> result = service.search(svo);
        System.out.println(result);
        return Libs.makeToastJsonResult(result);   
    }
    
    //http://localhost:8081/qna/qWriter
	@GetMapping("/qWriter")
	public String qWriter() {
		return "user_ComuQnAwrite"; //.html
	}
	
	
	// 기능 : Qna_user 글쓰기 (위"/qnawriter 과 동일한 기능)
	// param : QnaVO중 - ID(자동대입), nickname(로그인사용자 닉네임 자동 대입),
	// no(자동대입), cate_Id, isPub(공개(Y)/비공개(N)), title, q
	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@PostMapping("/insert")
	public @ResponseBody String insert(@RequestBody QnaVO vo) {
		System.out.println(className + ".insert() : " + vo.toString());
		vo.setCuser("user");
		return service.insert(vo).toString();
	}

	// 기능 : Qna_user 글 수정하기
	// param : QnaVO 중 - ID(insert된 ID/자동대입), no(insert된 no/자동대입), cate_ID,
	// isPub(공개(Y)/비공개(N)),
	// title, q
	// http://localhost:8081/qna/qupdate?title=cddcdd&q=aaaaa&cateId=bbbb&isPub=y&id=

	 //http://localhost:8081/qna/qUpdate
		@GetMapping("/qUpdate")
		public String qUpdate(String id) {
			ServletRequestAttributes servletRequestAttribute =
					(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			
			HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
			
			httpSession.setAttribute("id", id);

			return "user_ComuQnAUpdate";
		}
//	http://localhost:8081/qna/updateQ
	@PostMapping("/updateQ")
	public @ResponseBody String updateQ(@RequestBody QnaVO vo) {
		System.out.println(className + ".updateQ():" + vo.toString());
		return service.updateQ(vo).toString();
	}

	// http://localhost:8081/qna/aWriter
	@GetMapping("/aWriter")
	public String aWriter() {
		return "admin_comu_QnAList_Write";
	}
	// 기능 : Qna_admin 답변쓰기
	// param : QnaVO 중 - id(insert된 ID/자동대입), a, title(DB저장된 title 자동 대입)
	
//	http://localhost:8081/qna/updateA?id=&a=
	@GetMapping("/updateA")
	public @ResponseBody String aupdate(QnaVO vo) {
		System.out.println(className + "updateA():" + vo.toString());
		return service.updateQ(vo).toString();
	}

	// 기능 : Qna_admin 게시글 삭제
	// param :QnaVO 중 - id(insert된 ID/자동대입)
	// http://localhost:8081/qna/delete?id=
	@PostMapping("/delete")
	public @ResponseBody String delete(@RequestBody QnaVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return service.delete(vo).toString();
	}
	
	// http://localhost:8081/qna/searchDate
		@GetMapping("/searchData")
		public @ResponseBody Object getData4Toast3(QnaSearchVO svo) {
			System.out.println(className + ".getData4Toast3()");

			List<QnaVO> lstQnaResult = service.search(svo);
			return Libs.makeToastJsonResult(lstQnaResult);
		}


//	    http://localhost:8081/qna/adminList
		@GetMapping("/adminList")
		public String adminList() {
			return "admin_comu_QnA";
		}

	///  http://localhost:8081/qna/userList
		@GetMapping("/userList")
		public String userList() {
			return "user_ComuQnAList";

		}
		
		// http://localhost:8081/qna/userQna
			@GetMapping("/userQna")
			public String userQna(String id) {
				ServletRequestAttributes servletRequestAttribute =
						(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
				
				HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
				
				httpSession.setAttribute("id", id);

				return "user_QnA";
			}

			
			@GetMapping("/selectCnt")
			public @ResponseBody List<QnaVO> selectCnt(){
				System.out.println(className+ " selectCnt()");
				return service.selectCnt();
				
			}

	
	
}