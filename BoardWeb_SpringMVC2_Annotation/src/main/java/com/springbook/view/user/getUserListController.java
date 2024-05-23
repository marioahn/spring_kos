package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class getUserListController {
	
	@RequestMapping("/getUserList.do")
	public String getUserList (UserVO vo, UserDAO userDAO, Model model) {
		model.addAttribute("userList", userDAO.getUserList(vo));
		return "getUserList.jsp";
	}
}
