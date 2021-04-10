package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.StayListDAO;
import com.team3.prj.vo.StayListSearchResultVO;
import com.team3.prj.vo.StayListSearchVO;
import com.team3.prj.vo.StayListSearchVO2;
import com.team3.prj.vo.StayListVO;

@Service
public class StayListServiceImpl implements StayListService {


	@Autowired
	StayListDAO staylistDao;


	@Override
	public List<StayListVO> StayListAll(){
		return staylistDao.StayListAll();
	}

	@Override
    public List<StayListSearchVO> SearchAll(){ //수정
		return staylistDao.SearchAll();
	}

    @Override
    public List<StayListSearchResultVO> search(StayListSearchVO2 vo) {
        return staylistDao.search(vo);
    }
}
