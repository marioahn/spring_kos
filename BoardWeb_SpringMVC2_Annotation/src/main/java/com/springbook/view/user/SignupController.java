package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class SignupController {
	@RequestMapping("/signup.do")
	public String singup(UserVO vo, UserDAO userDAO) {
		
		userDAO.insertUser(vo);
		return "login.jsp"; // 회원가입 마치면 다시 로그인 화면으로 ㄱㄱ
	}

}
