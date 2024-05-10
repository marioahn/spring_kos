package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	// 이게 있어야 configuration파일에서 property로 UserDAO를 설정할 수 있음
	// 심지어 set은 소문자로 써야 함. SetUserDAO했더니 안되었음;;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.createUser(vo);
	}
}
