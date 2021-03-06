package com.team3.prj.service;

import java.util.List;

import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserSearchVO;
import com.team3.prj.vo.UserVO;

public interface UserService {
	
	//admin 회원리스트
	public List<UserVO> userAll();
	
	public UserVO login(UserVO vo);
	
	public UserVO myMain(UserVO vo);
	
	public String join(UserVO vo);
	
	public int checkDuplId(String id);
	
	public UserVO mypage(UserVO vo);
	
	public String update(UserVO vo);
	
	public int delete(UserVO vo);

	//manager
	public String mUpdate(UserVO vo);

	//user Review
	public List<RevuVO> revu();
	
	//리뷰 삭제
	public Long revuDelete(RevuVO vo);

	public List<UserVO> userSearch(UserSearchVO svo);
	
}