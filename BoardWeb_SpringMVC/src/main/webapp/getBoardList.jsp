<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<!-- JSTL����� ���� taglib���ù�! -->
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<% 
	/* List<BoardVO> boardList = (List) session.getAttribute("boardList");
	���⵵, java�ڵ� �����ϰ�, EL + JSTL�� ��ü! - for������ */
%>

<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
<link rel="stylesheet" href="resources/board_styles.css">
</head>
<body>
	<center>
	<h1>�� ��� - ToTheMoon </h1>
	<h3>�׽�Ʈ�� ȯ���մϴ�... <a href="logout.do">Log-Out</a></h3>
		
	<!-- �˻� ���� -->
	<form action="getBoardList.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<option value="TITLE">����
					<option value="CONTENT">����
				</select>
				<input name="searchKeyword" type="text"/>
				<input type="submit" value="�˻�"/>
			</td>
		</tr>
	</table>
	</form>
	<!-- �˻� ���� -->
	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">��ȣ</th>
			<th bgcolor="orange" width="200">����</th>
			<th bgcolor="orange" width="150">�ۼ���</th>
			<th bgcolor="orange" width="150">�����</th>
			<th bgcolor="orange" width="100">��ȸ��</th>
		</tr>
		<!-- JSTL��! -->
		<%-- <% for(BoardVO board: boardList) { %> --%>
		<c:forEach items="${boardList }" var="board">
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>
		
	</table>	

	<br>
	<a href="insertBoard.jsp">�� �� ���</a>
	</center>
</body>
</html>