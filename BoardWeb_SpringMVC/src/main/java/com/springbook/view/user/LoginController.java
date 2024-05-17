package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

// 이건 controller임. dispatcherServlet하고 분리되었음 이제 (p.293그림 참고!)
public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. DB연동 처리
		UserVO vo = new UserVO();
		vo.setU_id(id); 
		vo.setU_pw(password);
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		// 3. 화면 네비게이션
		if (user != null) {
			// response.sendRedirect("getBoardList.do"); // 이제 이게 아님
			return "getBoardList.do"; // 이걸 dispatcher한테 던져주는 것임ㅇㅇ
		} else {
			// response.sendRedirect("login.jsp");
			return "login"; // ..? 그냥 이렇게만?
		} 
	}

}
