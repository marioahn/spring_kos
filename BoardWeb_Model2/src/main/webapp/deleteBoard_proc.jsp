<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
/* 	// 1. ����� �Է� ���� ����
	// request.setCharacterEncoding("EUC-KR"); �ʿ�x
	String seq = request.getParameter("seq");
	
	// 2. DB���� ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq)); // �Է°��� string���״�, Intȭ ������� �ҵ�!
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(vo);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp"); */
%>