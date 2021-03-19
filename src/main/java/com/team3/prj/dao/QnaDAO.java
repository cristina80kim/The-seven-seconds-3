package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.QnaVO;

@Mapper //jdbc인 경우 @Resource
public interface QnaDAO { //결과를 List<QnaVO>에 넣어줌   //jdbc인 경우 public class QnaDAO 로 표현
	public List<QnaVO> qnaSelectAll(); //mybatis에 있는 id에 해당되는거 selectAll  mapper.xml 로 감

	public String qnaInsert(QnaVO param);
}
