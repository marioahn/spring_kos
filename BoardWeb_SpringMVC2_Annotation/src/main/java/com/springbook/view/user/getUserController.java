package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
@SessionAttributes("user")
public class getUserController {
	
	@RequestMapping("/getUser.do")
	public String getUser(UserVO vo, UserDAO userDAO, Model model) {
		model.addAttribute("user", userDAO.getUserOne(vo));
		
		return "getUser.jsp";
	}
}