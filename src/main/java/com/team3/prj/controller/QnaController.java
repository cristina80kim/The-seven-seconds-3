package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.QnaService;
import com.team3.prj.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	private final String className = "QnaController";

	@Autowired
	QnaService service;

	// http://localhost:8081/qna/frmSelectAll
	@GetMapping("/frmSelectAll")
	public String frmSelectAll() {
		System.out.println(className + ".frmSelectAll()");
		return "frmQnaSelectAll"; // .html
	}

	// http://localhost:8081/qna/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<QnaVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	/*
	 * // 기능 : Qna_user 글쓰기(html연결함) // pram : QnaVO중 - ID(자동대입), nickname(로그인사용자
	 * 닉네임 자동 대입), // no(자동대입), cate_Id, isPub(공개(Y)/비공개(N)), title, q //
	 * http://localhost:8081/qnawriter
	 * 
	 * @GetMapping("/qnawriter") public String qnaWriter() { System.out.println("");
	 * return "user_ComuQnAwrite"; }
	 */
	
	
	// 기능 : Qna_user 글쓰기 (위"/qnawriter 과 동일한 기능)
	// param : QnaVO중 - ID(자동대입), nickname(로그인사용자 닉네임 자동 대입),
	//        		   no(자동대입), cate_Id, isPub(공개(Y)/비공개(N)), title, q
	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@GetMapping("/insert")
	public @ResponseBody String insert(QnaVO vo) {
		System.out.println(className + ".insert() : " + vo.toString());
		return service.insert(vo).toString();
	}
		
	// 기능 : Qna_user 글 수정하기
	// param : QnaVO 중 - ID(insert된 ID/자동대입), no(insert된 no/자동대입), cate_ID, isPub(공개(Y)/비공개(N)),
	//	 	  			title, q
	// http://localhost:8081/qna/update?title=cddcdd&q=aaaaa&cateId=bbbb&isPub=y&id=
	@GetMapping("/qupdate")
	public @ResponseBody String qupdate(QnaVO vo) {
		System.out.println(className + ".Qupdate():" + vo.toString());
		return service.qupdate(vo).toString();
	}

	// 기능 : Qna_admin 답변쓰기
	// param : QnaVO 중 - id(insert된 ID/자동대입), a
	@GetMapping("/aupdate")
	public @ResponseBody String aupdate(QnaVO vo) {
		System.out.println(className + "Aupdate():" + vo.toString());
		return service.aupdate(vo).toString();
	}
	
	// 기능 : Qna_admin 게시글 삭제
	// param : id(insert된 ID/자동대입)
	// http://localhost:8081/qna/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(QnaVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return service.delete(vo).toString();
	}

}