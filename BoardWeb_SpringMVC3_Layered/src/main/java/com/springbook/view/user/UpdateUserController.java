package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
@SessionAttributes("user")
public class UpdateUserController {
	
	@RequestMapping("/updateUser.do")
	public String updateUser(@ModelAttribute("user") UserVO vo, UserDAO userDAO) {
		System.out.println("pw: " + vo.getU_pw());
		System.out.println("pwc: " + vo.getU_pwc());
		System.out.println("addr: " + vo.getU_addr());
		System.out.println("phone: " + vo.getU_phone());
		System.out.println("hobby: " + vo.getU_hobby());
		System.out.println("introduce: " + vo.getU_introduce());
		
		userDAO.updateUser(vo); 
		return "getUserList.do";
	}
}
