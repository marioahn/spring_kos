<%@ page import="com.springbook.biz.user.impl.UserDAO"%>
<%@ page import="com.springbook.biz.user.UserVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	// 1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB연동 처리
	UserVO vo = new UserVO();
	vo.setU_id(id); // 매개변수id는 html태그의 name속성과 같아야함
	vo.setU_pw(password);
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게이션
	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>