<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<!-- 여기는 _proc.jsp파일이 아니고, 그냥 한 파일안에 back,front코드 같이 있음ㅇㅇ. -->
<%
	// 1. 사용자 입력 정보 추출(검색은 나중에)
	// 2. DB연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
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
	<h3>테스트님 환영합니다... <a href="logout_proc.jsp">Log-Out</a></h3>
		
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
			<!-- 아래처럼 style하고 그 안에 넣는 방식이 권장 // td align="center"처럼 쌩으로 넣는건 정식.비추임ㅇㅇ.  -->
			<td style="text-align: center;"><%= board.getSeq() %></td>
			<!-- 이건 심지어, Title에 a링크걸어둠! -> 상세페이지로. by "jsp?seq=" ! -->
			<!-- 현재, board_styles.css에도 똑같이 td정해놨는데, 우선순위는 직접넣는것보단 낮음ㅇㅇ. 아래칸은 left로! -->
			<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>">
			<%= board.getTitle() %></a></td>
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