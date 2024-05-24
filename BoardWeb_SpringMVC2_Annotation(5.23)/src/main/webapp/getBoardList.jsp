<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<!-- JSTL사용을 위한 taglib지시문! -->
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<% 
	/* List<BoardVO> boardList = (List) session.getAttribute("boardList");
	여기도, java코드 제거하고, EL + JSTL로 대체! - for문ㅇㅇ */
%>

<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
<link rel="stylesheet" href="resources/board_styles.css">
</head>
<body>
	<center>
	<h1>글 목록 - ToTheMoon </h1>
	<h3>[${userName}]님 환영합니다! <a href="logout.do">Log-Out</a></h3>
		
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<!-- <option value="TITLE">제목
					<option value="CONTENT">내용 -->
				<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}
				</c:forEach>
				</select>
				<input name="searchKeyword" type="text"/>
				<input type="submit" value="검색"/>
			</td>
		</tr>
	</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		<!-- JSTL로! -->
		<%-- <% for(BoardVO board: boardList) { %> --%>
		<!-- GetBoardListController에서
			-> model.addAttribute("boardList", boardDAO.getBoardList(vo)); 했음
			-> boardList라고 정해줬다. model에 저장하고. 그래서 여기서 그걸 꺼내쓸 수 있는거임. ${boardList}로!!
		 -->
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
	<a href="insertBoard.jsp">새 글 등록</a>
	<br>
	<hr>
	<img src="resources/tothemoon.jpg" alt="Header Image" style="width:50%; max-width:300px; height:auto;">
	</center>
</body>
</html>