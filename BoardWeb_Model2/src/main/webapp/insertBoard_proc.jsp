<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
/* 	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("EUC-KR");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 2. DB연동 처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title); // 매개변수title은 html태그의 title 네임 속성
	vo.setWriter(writer);
	vo.setContent(content);
	
	// 어.. 그런데, 이렇게 하는게 왜 전체 등록이지.. 이렇게 매번 생성되는 객체는 다른거 아니냐..
	// 아오 또 멍청한 소리하고 있니.. DAO잖아 그냥.. insert메서드 쓸 수 있도록 하는거 가져오는 거임 걍..
	// insert실행되면 함수안의 로직으로 insert Query가 DB에 날라가는 거고
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp"); */
%>