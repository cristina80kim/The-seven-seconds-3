package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.QnaVO;

public interface QnaService {
public List<QnaVO> selectAll();
public Long insert(QnaVO vo);
}