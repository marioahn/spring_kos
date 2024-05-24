package com.springbook.biz.user;

import java.util.List;

// 이 userService에서 "Service"는 Business Layer쪽임! 계층패턴의 그 서비스 맞음
// 이제, @Controller의 DAO로직(비즈니스 로직)부분을 Service로 옮길 것임(분리)
// 인터페이스에 추상메서드 만들고, -> 
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
