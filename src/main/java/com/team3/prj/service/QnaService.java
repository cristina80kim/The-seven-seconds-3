package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.QnaSearchVO;
import com.team3.prj.vo.QnaVO;

public interface QnaService {
public List<QnaVO> selectAll();
public Long insert(QnaVO vo);
public Long updateQ(QnaVO vo);
public Long updateA(QnaVO vo);
public Long delete(QnaVO vo);
public List<QnaVO> search(QnaSearchVO svo);
public List<QnaVO> selectOne(QnaVO vo);
///
public List<QnaVO> selectCnt();
}