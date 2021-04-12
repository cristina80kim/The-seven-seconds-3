package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.QnaSearchVO;
import com.team3.prj.vo.QnaVO;

@Mapper
public interface QnaDAO {
	public List<QnaVO> selectAll();

	public Long insert(QnaVO vo);

	public Long updateQ(QnaVO vo);
		
	public Long updateA(QnaVO vo);
	
	public Long delete(QnaVO vo);
	
	public List<QnaVO> search(QnaSearchVO svo);

	public List<QnaVO> selectOne(QnaVO vo);

	public Integer selectCnt(QnaSearchVO svo);
	
	// 커밋
}