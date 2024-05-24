package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	// (Servlet API - p.384~ )
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인!");
		
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getU_name()); // SetAttribute: servlet API중 하나!
			if (user.getU_id().equals("admin") && user.getU_pw().equals("admin123")) { // ==쓰면 false뜸. ==는 두 객체의 메모리 주소를 비교함ㅇㅇ
				return "getUserList.do";
			}
			return "getBoardList.do";
		} 
		else return "login.jsp"; // 로그인 실패
	}
}
	
//  // (p.379)Get, Post둘다 value(요청 경로)는 같으나, method가 다르기에, 구분이 된다!
//	// do요청시, 어느 메서드를 실행시킬지에 대한 혼선이 x
//	// 그러나, 이 Get방식은 보안문제 등 때문에 노노. 웬만하면 xx. 
//	@RequestMapping(value="/login.do", method=RequestMethod.GET)
//	public String loginView(UserVO vo) {
//		System.out.println("로그인 화면으로 이동");
//		vo.setU_id("test");
//		vo.setU_pw("test123");
//		// test, test123이 텍스트박스에 써져있는 상태로 이동함!!!!!
//		return "login.jsp";
//	}
//	
//	@RequestMapping(value="/login.do", method=RequestMethod.POST)
//	public String login(UserVO vo, UserDAO userDAO) {
//		System.out.println("로그인 인증 처리..");
//		if (userDAO.getUser(vo) != null) return "getBoardList.do";
//		else return "login.jsp";
//	}


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