package com.team3.prj.service;

import java.util.HashMap;
import java.util.List;

import com.team3.prj.vo.UserVO;

public interface UserService {
	
	public List<UserVO> selectAll();
	
	public UserVO login(UserVO vo);

	/* UserVO login(HashMap<String, String> map); */
	
	public UserVO join(UserVO vo);


}