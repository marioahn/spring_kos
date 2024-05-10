package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// BoardDAO와는 달리, 여기선 직접 bean등록으로 객체 생성하니까, 어노테이션ㄴㄴ
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD 기능 중, C만
	// 1. 회원 조회
	public UserVO createUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword("PASSWORD");
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return user;
	}
}
