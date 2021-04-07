package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.NoticeSearchVO;
import com.team3.prj.vo.NoticeVO;


@Mapper
public interface NoticeDAO {
	public List<NoticeVO> selectAll();

	public List<NoticeVO> selectOne(NoticeVO vo);

	public List<NoticeVO> search(NoticeSearchVO svo);

	public Long insert(NoticeVO vo);

	public Long update(NoticeVO vo);

	public Long delete(NoticeVO vo);

//	public List<NoticeVO> selectOne1(String result);
	
	//
	
}
