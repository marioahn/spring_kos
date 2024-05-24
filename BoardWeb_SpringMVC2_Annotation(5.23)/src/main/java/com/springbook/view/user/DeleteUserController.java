package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class DeleteUserController {
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(UserVO vo, UserDAO userDAO) {
		userDAO.deleteUser(vo);
		return "getUserList.do";
	}
}

