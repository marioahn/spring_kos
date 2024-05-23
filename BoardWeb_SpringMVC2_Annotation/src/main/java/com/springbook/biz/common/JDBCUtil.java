package com.springbook.biz.common;

// common파일인 이유는 대-부분의 다른 모든 패키지에서 활용할 것이라는 뜻. 모든이 아니어도 범용적인!
// 여기서 JDBCUtill도 각 기능의 DAO들에서 연결위해 쓰잖아 공통으로!
// <공통키워드> -> 이.걸.바로 횡단관심이라고 한다. AOP개념과도 연결
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); // sa, ""는 각 id, 비번
			// h2 DB의 'test' db에 연동하는 것! 참고로, test2, test3 .. 여러개 DB쓸 수도 있는거지!
			// 그리고, 현재 이 test(DB)에는 USERS,BOARD라는 2개의 테이블이 있는 상태!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
