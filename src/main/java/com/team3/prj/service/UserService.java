package com.team3.prj.service;

import java.util.HashMap;
import java.util.List;

import com.team3.prj.vo.UserVO;

public interface UserService {
	
	public List<UserVO> selectAll();
	
	public UserVO login(UserVO vo);
	
	public String join(UserVO vo);
	
	public UserVO mypage(UserVO vo);
	
	public String update(UserVO vo);
	
	public Long delete(UserVO vo);

}