package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 공통부분은 common패키지에 JDBCUtil클래스 안에 넣어둠ㅇㅇ.
public class JDBCUtil {
	public static Connection getConnection() { // Connection타입
		try {
			Class.forName("org.h2.Driver"); // h2에 연결
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); // 주소, adminId, pw임!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) stmt.close(); // close안되어있으면 close시켜라
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if (!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	// close함수 오버.로딩!
	// 이 경우는 어떤 경우겠어? ResultSet이 넘어오는 것은? -> interface에서 crud중 어떤게 return이 void가 아닌지 보셈
	// -> Select의 경우들!
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if (!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
