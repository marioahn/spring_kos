<!-- JSP파일은 HTML, JSP문법 모두사용가능하며,
	- JSP문법의 영역은 %와 %사이에 있는 부분들이다. 나머진 모두 HTML!
 -->
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<link rel="stylesheet" href="resources/board_styles.css">
</head>
<body>
	<center>
	<h1>로그인</h1>
	<hr>
	<!-- form action: 웹페이지에서 사용자 입력을 받아, login_proc.jsp파일로 post되는 것임
	& model2오면서, login_proc.jsp에서 login.do로 변경! -->
	<form action="login.do" method="post">
	<table border="1" cellpadding="1" cellspacing="0">
		<tr>
			<td bgcolor="orange">아이디</td>
			<td><input type="text" name="u_id"></td>
		</tr>
		<tr>
			<td bgcolor="orange">비밀번호</td>
			<td><input type="password" name="u_pw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인"/>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	</center>
</body>
</html>