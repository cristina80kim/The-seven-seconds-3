package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.QnaVO;

@Mapper
public interface QnaDAO {
	public List<QnaVO> qnaSelectAll();

	public Long qnaInsert(QnaVO vo);
}