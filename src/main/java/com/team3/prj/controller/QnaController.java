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
            {className2 + "qWriter", Common.strRoleAMUY},            
            {className2 + "insert", Common.strRoleAMUY},            
            {className2 + "qUpdate", Common.strRoleAMUY},            
            {className2 + "updateQ", Common.strRoleAMUY},            
            {className2 + "aWriter", Common.strRoleAMUY},            
            {className2 + "updateA", Common.strRoleAMUY},            
            {className2 + "delete", Common.strRoleAMUY},            
            {className2 + "searchData", Common.strRoleAMUY},            
            {className2 + "adminList", Common.strRoleAMUY},            
            {className2 + "userList", Common.strRoleAMUY},
            {className2 + "userQna", Common.strRoleAMUY},
            {className2 + "selectCnt", Common.strRoleAMUY},
            
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
		System.out.println("?????? : " + vo);
		List<QnaVO> result = service.selectOne(vo);
		System.out.println("?????? : " + result);
		return result;
	}
	
	// ?????? : Qna ?????? ??????
	// param : QnaSearchVO??? - cateIdValue(???????????? ???),searchType(??????,?????????),keyWord(?????????)
	// http://localhost:8081/qna/search?cateId=&keyWord=
	@GetMapping("/search")
	public @ResponseBody List<QnaVO> search(QnaSearchVO svo) {
		System.out.println(className + ".search()");
        System.out.println(svo);
		return service.search(svo);
	}
	
	// ?????? TOAST grid??? ?????? ?????? ??? ?????? ??????	
    // http://localhost:8081/qna/toastSearch?cateId=&keyWord=
    @GetMapping("/toastSearch")
    public @ResponseBody JSONObject toastSearch(QnaSearchVO svo) {
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
	
	
	// ?????? : Qna_user ????????? (???"/qnawriter ??? ????????? ??????)
	// param : QnaVO??? - ID(????????????), nickname(?????????????????? ????????? ?????? ??????),
	// no(????????????), cate_Id, isPub(??????(Y)/?????????(N)), title, q
	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@PostMapping("/insert")
	public @ResponseBody String insert(@RequestBody QnaVO vo) {
		System.out.println(className + ".insert() : " + vo.toString());
		vo.setCuser("user");
		return service.insert(vo).toString();
	}

	// ?????? : Qna_user ??? ????????????
	// param : QnaVO ??? - ID(insert??? ID/????????????), no(insert??? no/????????????), cate_ID,
	// isPub(??????(Y)/?????????(N)),
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
	// ?????? : Qna_admin ????????????
	// param : QnaVO ??? - id(insert??? ID/????????????), a, title(DB????????? title ?????? ??????)
	
//	http://localhost:8081/qna/updateA?id=&a=
	@GetMapping("/updateA")
	public @ResponseBody String updateA(QnaVO vo) {
		System.out.println(className + "updateA():" + vo.toString());
		return service.updateQ(vo).toString();
	}

	// ?????? : Qna_admin ????????? ??????
	// param :QnaVO ??? - id(insert??? ID/????????????)
	// http://localhost:8081/qna/delete?id=
	@PostMapping("/delete")
	public @ResponseBody String delete(@RequestBody QnaVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return service.delete(vo).toString();
	}
	
	// http://localhost:8081/qna/searchDate
		@GetMapping("/searchData")
		public @ResponseBody Object searchData(QnaSearchVO svo) {
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
			public @ResponseBody Integer selectCnt(QnaSearchVO svo){
				System.out.println(className+ " selectCnt()");
				return service.selectCnt(svo);
				
			}

	// ??????
	
}