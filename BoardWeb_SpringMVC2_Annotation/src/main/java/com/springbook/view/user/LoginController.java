package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인!");
		System.out.println(vo);
		if (userDAO.getUser(vo) != null) return "getBoardList.do";
		else return "login.jsp";
	}
}


//@Override
//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//	System.out.println("로그인 처리");
//	
//	// 1. 사용자 입력 정보 추출
//	String id = request.getParameter("id");
//	String password = request.getParameter("password");
//	
//	// 2. DB연동 처리
//	UserVO vo = new UserVO();
//	vo.setU_id(id); 
//	vo.setU_pw(password);
//	UserDAO userDAO = new UserDAO();
//	UserVO user = userDAO.getUser(vo);
//	
//	// 3. 화면 네비게이션
//	ModelAndView mav = new ModelAndView();
//	if (user != null) {
//		// return "getBoardList.do"; // 이걸 dispatcher한테 던져주는 것임ㅇㅇ
//		// mav.setViewName("getBoardList.do"); // viewResolver적용 전
//		mav.setViewName("redirect:getBoardList.do"); // redircet: viewResolver무시하고, 이 링크로 강제로 보냄!
//	} else {
//		// return "login"; 
//		// mav.setViewName("login.jsp"); // do가 아니라 jsp페이지로ㅇㅇ & viewResolver적용 전
//		mav.setViewName("redirect:login.jsp");
//	}
//	return mav;
//}