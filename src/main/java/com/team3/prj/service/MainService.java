package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.CommonCodeVO;

public interface MainService {

    List<CommonCodeVO> selectCommonCodes(CommonCodeVO vo);

}
