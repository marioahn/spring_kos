package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo);
	public UserVO getUserOne(UserVO vo);
	public List<UserVO> getUserList(UserVO vo);
	
	public void insertUser(UserVO vo);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);

}
