package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.QnaDAO;
import com.team3.prj.vo.QnaVO;

@Service //여기가 service다 서비스관련된거 입력해준다
public class QnaServiceImpl implements QnaService { 

	@Autowired // qnaDAO라는 변수에 객체값이 들어감
	QnaDAO qnaDAO; //bean 객체 Autowired에 담아준다.
	//ctrl 누르고 왼쪽키 누르면 QnaDAO로 감

	@Override //부모에서 정의되어있는 메소드를 재정의 할때 씀
	public List<QnaVO> selectAll() {//selectAll 부르면 여기로옴
		return qnaDAO.qnaSelectAll(); //qnaDAO에 selectAll을 부르러감
	}

	@Override
	public String insert(QnaVO param) {
		return qnaDAO.qnaInsert(param);
	}

}
