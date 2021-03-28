package com.team3.prj.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.UserVO;

@Mapper
public interface UserDAO {
	public List<UserVO> userSelectAll();
	
	public UserVO userLogin(UserVO vo);
	
	public UserVO userJoin(UserVO vo);

}