package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserVO;

public interface UserService {
	
	public List<UserVO> selectAll();
	
	public UserVO login(UserVO vo);
	
	public String join(UserVO vo);
	
	public UserVO mypage(UserVO vo);
	
	public String update(UserVO vo);
	
	public Long delete(UserVO vo);

	//manager
	public String mUpdate(UserVO vo);

	//user Review
	public List<RevuVO> revu();

	public Long revuDelete(RevuVO vo);
	

}