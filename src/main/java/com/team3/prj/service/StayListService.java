package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.StayListSearchResultVO;
import com.team3.prj.vo.StayListSearchVO;
import com.team3.prj.vo.StayListSearchVO2;
import com.team3.prj.vo.StayListVO;
//수정
public interface StayListService {

    public List<StayListSearchResultVO> search(StayListSearchVO2 vo);
}
