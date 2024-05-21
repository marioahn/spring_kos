package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// servlet을 이해하니, 왜 http서블릿을 상속받는지 알겠음
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // static final: 상수 - 절대 안 바뀜
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    /* public DispatcherServlet() {super();} // 이거 대신에, init() 초기화 함수로 할 것
     * 서블릿의 init()메소드는 서블릿 객체가 생성된 후에 멤버변수를 초기화하기 위해 자동으로 실.행되는 것 
	 */
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // './'는 현재 디.렉토리를 의미한다!!!!
		viewResolver.setSuffix(".jsp");
		// viewResolver.getView함수 봐보셈 -> './login.jsp'은? -> './'가 접두사, login이 viewName, .jsp가 접미사!
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		request.setCharacterEncoding("EUC-KR"); // or UTF-8
		process(request, response);
	}
	
	/* web.xml에 서블릿 설정이 추가되고, 클라이언트의 모든 *.do요청(doPost,doGet)을
	  -> dispatcherServlet클래스의 객체가 처리!(process) */
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path정보를 추출한다
		String uri = request.getRequestURI(); // http://localhost:8080/BoardWeb/login.do
		String path = uri.substring(uri.lastIndexOf("/")); // '/login.do'
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다
		String view = null;
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동한다
		response.sendRedirect(view);
	}
	
}
