package com.springbook.view.controller;

/* 파일이름은 고정으로하기 - DisPatcherServlet으로!
 * 이게 바로, controller다
 * model1에서 webapp쪽에 속해있던,모든 _proc.jsp를 view.controller패키지로 옮길 것이다!  
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/*Servlet implementation class DispatcherServlet */

// servlet을 이해하니, 왜 http서블릿을 상속받는지 알겠음
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // static final: 상수 - 절대 안 바뀜
       
	/* @see HttpServlet#HttpServlet() */
    public DispatcherServlet() {
        super(); // 부모클래스인 http서블릿의 멤버,메서드를 그~대로 가져올 것
    }

    /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		request.setCharacterEncoding("EUC-KR"); // or UTF-8
		process(request, response);
	}
	
	/* web.xml에 서블릿 설정이 추가되고, 클라이언트의 모든 *.do요청(doPost,doGet)을
	 * ->dispatcherServlet클래스의 객체가 처리!(process) 	 */
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path정보를 추출한다
		String uri = request.getRequestURI(); // http://localhost:8080/BoardWeb/login.do
		String path = uri.substring(uri.lastIndexOf("/")); // '/login.do'
		System.out.println("path: " + path);
		
		// 2. 클라이언트의 요청 path에 따른 분기처리
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			// 2. DB연동 처리
			UserVO vo = new UserVO();
			vo.setU_id(id); 
			vo.setU_pw(password);
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			// 3. 화면 네비게이션
			if (user != null) {
				response.sendRedirect("getBoardList.do");
				// 이제 여기 .jsp로 하면 못알아먹음. why? -> 바로 여기 이 파일인 dispatcherServlet.java파일이 실행x니까(do요청에만 응답함)
				/* TODO: 그러면, getBoardList.do로 가게 되면, 이게 또 다시 doGet메서드에 의해 process가 다시 실행되고,
				 * 아래 getBoardList분기로 들어가게 되는 것? ㅇㅇ 그게 맞음
				 */
			} else {
				response.sendRedirect("login.jsp"); // 이건 do가 아니지. 원래 login페.이지로 back해야 하니까
				// 즉, login.do로직을 실행하는게 아니다! 
			}
			
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			// 1. 브라우저와 연결된 세션 객체를 강제 종료
			HttpSession session = request.getSession();
			session.invalidate(); 
			// 2. 세션 종료 후, 메인 화면으로 이동한다 - 이건 do로 가면 큰일 나겠지!
			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			// 1. 사용자 입력 정보 추출
			// request.setCharacterEncoding("EUC-KR"); // 없어도 됨. 위에서 doPost가 일괄적으로 먼저 해주잖아ㅇㅇ.!
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			// 2. DB연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title); 
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do"); // jsp가 아니라, do겠지 갱신된 것을 다시 가져와야 하니까
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");
			// 2. DB연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");
			// 2. DB연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			// 3. 검색 결과를 세션에 저장하고, 상세 화면으로 이동한다
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			// 0. 사용자 입력 정보 추출(for 검색 기능 - 나중에 구현)
			// 1. DB연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			// 2. 검색 결과를 세.션.에 저장하고 목록 화면으로 이동한다 -> !이 코드가 추가적으로 필요함!
				// 원래는 boardList같은 정보는 세션에 저장하는건 아님ㅇㅇ.
				// 임시적으로 이렇게 ㄱㄱ하고, spring mvc에서 httpServletRequest객체에 담을 것임. 세션이 아니라
				// -> getBoardList.jsp의 java코드도 수정해줘야겠지
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList); // "boardList"이름을 가진 세션에 위에서 가져온 boardList를 저장(set)
			response.sendRedirect("getBoardList.jsp");
		}
	}
}
