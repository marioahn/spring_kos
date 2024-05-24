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
		return "login.jsp";
	}

}
