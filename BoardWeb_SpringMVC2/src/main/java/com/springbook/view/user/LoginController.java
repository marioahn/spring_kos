package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller; 
//spring에서 제공해주는 Controller클래스! - 얘는 return타입이 ModelAndView객체임

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			// return "getBoardList.do"; // 이걸 dispatcher한테 던져주는 것임ㅇㅇ
			mav.setViewName("getBoardList.do");
		} else {
			// return "login"; 
			mav.setViewName("login.jsp"); // do가 아니라 jsp페이지로ㅇㅇ
		}
		return mav;
	}

}
