package com.team3.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.QnaService;
import com.team3.prj.vo.QnaSearchVO;
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

//	http://localhost:8081/qna/oneSelect?id=1000000001
	@GetMapping("/oneSelect")
	public @ResponseBody List<QnaVO> selectOne(QnaVO vo){
		System.out.println(className + "selectOne()");
		return service.selectOne(vo);
	}
	// 기능 : Qna 목록 검색
	// param : QnaSearchVO중 - cateIdValue(카테고리 값),searchType(제목,닉네임),keyWord(검색어)
	// http://localhost:8081/qna/search?cateId=&keyWord=
	@GetMapping("/search")
	public @ResponseBody List<QnaVO> qnaSearch(QnaSearchVO svo) {
		System.out.println(className + ".search()");
		return service.search(svo);
	}
//	http://localhost:8081/qna/qWriter
	@GetMapping("/qWriter")
	public String qWriter() {
		return "user_ComuQnAwrite"; //.html
	}
	
	
	// 기능 : Qna_user 글쓰기 (위"/qnawriter 과 동일한 기능)
	// param : QnaVO중 - ID(자동대입), nickname(로그인사용자 닉네임 자동 대입),
	// no(자동대입), cate_Id, isPub(공개(Y)/비공개(N)), title, q
	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@GetMapping("/insert")
	public @ResponseBody String insert(QnaVO vo) {
		System.out.println(className + ".insert() : " + vo.toString());
		return service.insert(vo).toString();
	}

	// 기능 : Qna_user 글 수정하기
	// param : QnaVO 중 - ID(insert된 ID/자동대입), no(insert된 no/자동대입), cate_ID,
	// isPub(공개(Y)/비공개(N)),
	// title, q
	// http://localhost:8081/qna/qupdate?title=cddcdd&q=aaaaa&cateId=bbbb&isPub=y&id=

	@GetMapping("/updateQ")
	public @ResponseBody String updateQ(QnaVO vo) {
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
	@GetMapping("/updateA")
	public @ResponseBody String aupdate(QnaVO vo) {
		System.out.println(className + "updateA():" + vo.toString());
		return service.updateQ(vo).toString();
	}

	// 기능 : Qna_admin 게시글 삭제
	// param :QnaVO 중 - id(insert된 ID/자동대입)
	// http://localhost:8081/qna/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(QnaVO vo) {
		System.out.println(className + ".delete():" + vo.toString());
		return service.delete(vo).toString();
	}

}