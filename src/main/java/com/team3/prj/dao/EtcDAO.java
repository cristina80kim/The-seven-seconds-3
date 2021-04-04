package com.team3.prj.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.NoteVO;

@Mapper
public interface EtcDAO {

    NoteVO select(NoteVO vo);

    int insert(NoteVO vo);

    int update(NoteVO vo);

    int delete(NoteVO vo);

}
