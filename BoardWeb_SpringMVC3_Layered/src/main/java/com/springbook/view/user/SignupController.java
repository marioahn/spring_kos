package com.springbook.view.user;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class SignupController {
	
	@RequestMapping("/signup.do")
	public String insertUser(UserVO vo, UserDAO userDAO) throws IOException { // signup()메서드명 말고 이걸로ㅇㅇ;ㅎ;
		MultipartFile uploadFile = vo.getU_pic();

		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/Users/A/1-eclipse-workspace/sts/work_space3/BoardWeb_SpringMVC3_Layered/src/main/webapp/resources/upload/userUploadFile/" + fileName;
			uploadFile.transferTo(new File(filePath)); // 파일 저장!!
		}
		
		userDAO.insertUser(vo);
		return "login.jsp";
	}

}
