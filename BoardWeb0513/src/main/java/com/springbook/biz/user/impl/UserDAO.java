package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

//DAO(Data Access Object)
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어들
	private final String USER_GET = "select * from users where u_id=? and u_pw=?";
	private final String USER_INSERT = "insert into users(u_seq, u_name, u_gender, u_id, u_pw, u_pwc, u_addr, u_email, u_phone, u_hobby, u_introduce) values((select nvl(max(u_seq), 0)+1 from users),?,?,?,?,?,?,?,?,?,?)";

	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getU_id());
			stmt.setString(2, vo.getU_pw());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setU_seq(rs.getInt("U_SEQ"));
				user.setU_name(rs.getString("U_NAME"));
				user.setU_gender(rs.getString("U_GENDER"));
				user.setU_id(rs.getString("U_ID"));
				user.setU_pw(rs.getString("U_PW"));
				user.setU_addr(rs.getString("U_ADDR"));
				user.setU_email(rs.getString("U_EMAIL"));
				user.setU_phone(rs.getString("U_PHONE"));
				user.setU_hobby(rs.getString("U_HOBBY"));
				user.setU_introduce(rs.getString("U_INTRODUCE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection(); // test db 가르킴
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getU_name()); //1번 ?
			stmt.setString(2, vo.getU_gender()); //2번 ?
			stmt.setString(3, vo.getU_id()); //3번 ?
			stmt.setString(4, vo.getU_pw());
			stmt.setString(5, vo.getU_pwc());
			stmt.setString(6, vo.getU_addr());
			stmt.setString(7, vo.getU_email());
			stmt.setString(8, vo.getU_phone());
			stmt.setString(9, vo.getU_hobby());
			stmt.setString(10, vo.getU_introduce());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//conn.close();
			//stmt.close();
			JDBCUtil.close(stmt, conn);
		}
	}
}
