package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.NoticeSearchVO;
import com.team3.prj.vo.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> selectAll();
	
	public List<NoticeVO> selectOne(NoticeVO vo);
	
	public List<NoticeVO> search(NoticeSearchVO svo);
	
	public Long insert(NoticeVO vo);

	public Long update(NoticeVO vo);
	
	public Long delete(NoticeVO vo);
	
//	public List<NoticeVO> selectOne(String result);
	//
}
