package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.MypageRsrvVO;

public interface MypageRsrvService {

	public List<MypageRsrvVO> selectAllMypage();

	public Long delete(MypageRsrvVO vo);
}
