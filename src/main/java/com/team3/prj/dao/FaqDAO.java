package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.service.FaqSearchVO;
import com.team3.prj.vo.FaqVO;

@Mapper
public interface FaqDAO {
	public List<FaqVO> selectAll();
	public List<FaqVO> selectOne(FaqVO vo);
	public List<FaqVO> search(FaqSearchVO svo);
	public Long insert(FaqVO vo);
	public Long update(FaqVO vo);
	public Long delete(FaqVO vo);
	
}
