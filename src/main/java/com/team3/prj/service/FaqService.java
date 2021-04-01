package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.FaqVO;


public interface FaqService {
	public List<FaqVO> selectAll();
	public List<FaqVO> selectOne(FaqVO vo);
	public List<FaqVO> search(FaqSearchVO svo);
	public Long insert(FaqVO vo);
	public Long update(FaqVO vo);
	public Long delete(FaqVO vo);
	
}
