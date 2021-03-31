package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.UserDAO;
import com.team3.prj.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

		@Autowired
		UserDAO userDAO;
		
		@Override
		public List<UserVO> selectAll() {
			return userDAO.userSelectAll();
		}
		
		@Override
		public UserVO login(UserVO vo) {
			return userDAO.userLogin(vo);
		}
		
		@Override
		public int join(UserVO vo) {
			return userDAO.userJoin(vo);
		}

		@Override
		public UserVO mypage(UserVO vo) {
			return userDAO.userMypage(vo);
		}

		@Override
		public Long update(UserVO vo) {
			return userDAO.userUpdate(vo);
		}

		@Override
		public Long delete(UserVO vo) {
			return userDAO.userDelete(vo);
		}
		
}