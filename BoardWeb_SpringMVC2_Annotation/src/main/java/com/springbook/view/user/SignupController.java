package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class SignupController {
	
	@RequestMapping("/signup.do")
	public String insertUser(UserVO vo, UserDAO userDAO) { // signup()메서드명 말고 이걸로ㅇㅇ;ㅎ;
		
		userDAO.insertUser(vo);
		return "getUserList.do"; // 회원가입하면 유저 전체 목록 화면으 로 ㄱㄱ(좀 이상하긴 해도 일단..)
		// return "login.jsp";
	}

}
