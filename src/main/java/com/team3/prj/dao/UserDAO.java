package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.UserVO;

@Mapper
public interface UserDAO {
	public List<UserVO> userSelectAll();
	
	public UserVO userLogin(UserVO vo);
	
	public int userJoin(UserVO vo);
	
	public UserVO userMypage(UserVO vo);
	
	public Long userUpdate(UserVO vo);
	
	public Long userDelete(UserVO vo);

}