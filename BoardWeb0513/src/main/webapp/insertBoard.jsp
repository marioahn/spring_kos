<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<title>새글 등록</title>
</head>
<body>
	<center>
	<h1>글 등록</h1>
	<hr>
	<a href="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="insertBoard_proc.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input type="text" name="title"></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left"><input type="text" name="writer" size="10"></td>
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="새 글등록"/>
				<!-- 그리고, insertBoard_porc.jsp파일을 만들어서 게시글db에 연동시키면 된다! -->
			</td>
		</tr>
	</table>
	</form>
	<hr>
	<a href="getBoardList.jsp">글 목록 가기</a>
	</center>
</body>
</html>