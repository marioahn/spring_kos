<!-- JSP������ HTML, JSP���� ��λ�밡���ϸ�,
	- JSP������ ������ %�� %���̿� �ִ� �κе��̴�. ������ ��� HTML!
 -->
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
<link rel="stylesheet" href="resources/board_styles.css">
</head>
<body>
	<center>
	<h1>�α���</h1>
	<hr>
	<!-- form action: ������������ ����� �Է��� �޾�, login_proc.jsp���Ϸ� post�Ǵ� ����
	& model2���鼭, login_proc.jsp���� login.do�� ����! -->
	<form action="login.do" method="post">
	<table border="1" cellpadding="1" cellspacing="0">
		<tr>
			<td bgcolor="orange">���̵�</td>
			<td><input type="text" name="u_id"></td>
		</tr>
		<tr>
			<td bgcolor="orange">��й�ȣ</td>
			<td><input type="password" name="u_pw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="�α���"/>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	</center>
</body>
</html>