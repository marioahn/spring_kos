package com.springbook.view.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.common.JDBCUtil;

@WebServlet("/checkId.do")
public class CheckIdServlet extends HttpServlet {
	// JDBC 관련 변수
	private Connection conn = null;
	
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("u_id");
        response.setContentType("text/plain");

        if (userId == null || userId.isEmpty()) {
            response.getWriter().write("unavailable");
            return;
        }
        
        // 
        try {
        	String sql = "SELECT COUNT(*) FROM users WHERE u_id = ?";
        	conn = JDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                response.getWriter().write("unavailable");
            } else {
                response.getWriter().write("available");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("unavailable");
        }
    }
}
