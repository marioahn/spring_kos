package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup한다.
		UserService userService = (UserService) container.getBean("userService");
		
		// 삽입 기능 테스트
		UserVO vo1 = new UserVO();
		vo1.setU_name("관리자");
		vo1.setU_gender("남");
		vo1.setU_id("test");
		vo1.setU_pw("test123");
		vo1.setU_pwc("test123");
		vo1.setU_addr("서울시 강북구");
		vo1.setU_email("jsh980123@gmail.com");
		vo1.setU_phone("01040345941");
		vo1.setU_hobby("게임, 음악듣기");
		vo1.setU_introduce("관리자입니다.");
		System.out.println(vo1);
		userService.insertUser(vo1);

		// 3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setU_id("test");
		vo.setU_pw("test123");

		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println(user.getU_name() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}

		// 4. Spring 컨테이너를 종료한다.
		container.close();

	}

}
