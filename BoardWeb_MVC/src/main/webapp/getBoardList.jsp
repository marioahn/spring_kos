<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<!-- 여기는 _proc.jsp파일이 아니고, 그냥 한 파일안에 back,front코드 같이 있음ㅇㅇ. -->
<%
	// 1. 사용자 입력 정보 추출(검색은 나중에)
	// 2. DB연동 처리
	/* BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo); */
	
	// Session에서 -> getAttribute함수를 이용하여 (매개변수인)"boardList"아디(name)를 가진 것을 찾아서 boardList에 저장! 
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
	// 3. 응답화면 구성
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
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다... <a href="logout.do">Log-Out</a></h3>
		
	<!-- 검색 시작 -->
	<form action="getBoardList.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<option value="TITLE">제목
					<option value="CONTENT">내용
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
		<!-- 반복문으로 tr 계속 생성ㅇㅇ -->
		<% for(BoardVO board: boardList) { %>
		<tr>
			<td style="text-align: center;"><%= board.getSeq() %></td>
			<td align="left">
				<!-- getBoard model1->2작업은 이게 제일 먼저임. 여기서 getBoard.do로 바꿔줘야 함!  -->
				<a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a>
			</td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getRegDate() %></td>
			<td><%= board.getCnt() %></td>
		</tr>
		<%  } %>
	</table>	

	<br>
	<a href="insertBoard.jsp">새 글 등록</a>
	</center>
</body>
</html>