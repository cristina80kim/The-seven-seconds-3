package com.team3.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.prj.dao.UserDAO;
import com.team3.prj.etc.Libs;
import com.team3.prj.etc.LoginManager;
import com.team3.prj.vo.RevuVO;
import com.team3.prj.vo.UserInstanceVO;
import com.team3.prj.vo.UserSearchVO;
import com.team3.prj.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

		@Autowired
		UserDAO userDAO;
		
		//admin 회원리스트
		@Override
		public List<UserVO> userAll() {
			return userDAO.userSearch(new UserSearchVO());
		}
		
		@Override
		public UserVO login(UserVO vo) {
			UserVO result = userDAO.userLogin(vo);
			String sessionId = Libs.getSession().getId();
			System.out.println(sessionId);
				if (result != null || result.getId() != null || result.getId().trim().length() >= 1) {
					LoginManager.setUserInfo(sessionId, new UserInstanceVO(result));
				}
			return userDAO.userLogin(vo);
		}
		
		@Override
		public String join(UserVO vo){
			return userDAO.userJoin(vo) >= 1 ? vo.getId() : "";
		}
		
		@Override
		public int checkDuplId(String id) {
			return userDAO.checkDuplId(id);
		}

		@Override
		public UserVO mypage(UserVO vo) {
			return userDAO.userMypage(vo);
		}

		@Override
		public String update(UserVO vo) {
			return userDAO.userUpdate(vo) >= 1 ? vo.getId() : "";
		}

		@Override
		public int delete(UserVO vo) {
			int result = userDAO.userDelete(vo);
			if (result != 0) {
				LoginManager.removeUserInfo(Libs.getSession().getId(), vo.getId());
			}
			return result;
		}

		//manager
		@Override
		public String mUpdate(UserVO vo) {
			return userDAO.managerUpdate(vo) >=1 ? vo.getId() : "";
		}

		@Override
		public List<RevuVO> revu() {
			return userDAO.userRevu();
		}

		@Override
		public Long revuDelete(RevuVO vo) {
			return userDAO.revuDelete(vo);
		}

		@Override
		public List<UserVO> userSearch(UserSearchVO svo) {
			return userDAO.userSearch(svo);
		}

		
		
}