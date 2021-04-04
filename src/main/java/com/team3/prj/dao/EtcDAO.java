package com.team3.prj.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.EtcVO;

@Mapper
public interface EtcDAO {

    String select(EtcVO vo);

    int insert(EtcVO vo);

    int update(EtcVO vo);

    int delete(EtcVO vo);

}
