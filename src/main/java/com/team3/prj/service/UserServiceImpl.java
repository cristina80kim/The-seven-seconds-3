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
}
