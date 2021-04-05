package com.team3.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserVO;

@Mapper
public interface UserDAO {
	
	//admin 회원리스트
	public List<UserVO> userSelectAll();
	
	public UserVO userLogin(UserVO vo);
	
	public int userJoin(UserVO vo);
	
	public int checkId(String id);
	
	public UserVO userMypage(UserVO vo);
	
	public Long userUpdate(UserVO vo);
	
	public Long userDelete(UserVO vo);
	
	//manager
	public Long managerUpdate(UserVO vo);

	// 리뷰리스트
	public List<RevuVO> userRevu();

	// 리뷰 삭제
	public Long revuDelete(RevuVO vo);
}