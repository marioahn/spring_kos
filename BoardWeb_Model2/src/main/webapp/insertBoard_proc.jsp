<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
/* 	// 1. ����� �Է� ���� ����
	request.setCharacterEncoding("EUC-KR");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 2. DB���� ó��
	BoardVO vo = new BoardVO();
	vo.setTitle(title); // �Ű�����title�� html�±��� title ���� �Ӽ�
	vo.setWriter(writer);
	vo.setContent(content);
	
	// ��.. �׷���, �̷��� �ϴ°� �� ��ü �������.. �̷��� �Ź� �����Ǵ� ��ü�� �ٸ��� �ƴϳ�..
	// �ƿ� �� ��û�� �Ҹ��ϰ� �ִ�.. DAO�ݾ� �׳�.. insert�޼��� �� �� �ֵ��� �ϴ°� �������� ���� ��..
	// insert����Ǹ� �Լ����� �������� insert Query�� DB�� ���󰡴� �Ű�
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(vo);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp"); */
%>