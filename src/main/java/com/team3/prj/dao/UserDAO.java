package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.UserVO;

@Mapper
public interface UserDAO {
	public List<UserVO> userSelectAll();

}
