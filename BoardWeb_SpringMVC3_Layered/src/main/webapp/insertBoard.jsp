<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<title>���� ���</title>
</head>
<body>
	<center>
	<h1>�� ���</h1>
	<hr>
	<a href="logout.do">Log-out</a>
	<hr>
	<!-- insertBoard_proc.jsp���� ���� - ���� _proc.jsp�� �� �����Ӥ��� -->
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">����</td>
			<!-- ��. ���� name �̻��ϰ� �Է��ϸ�, Setter�������� �ν� ���ϰ�, VO command��ü ��� ���� -->
			<td align="left"><input type="text" name="title"></td>
		</tr>
		<tr>
			<td bgcolor="orange">�ۼ���</td>
			<td align="left"><input type="text" name="writer" size="10"></td>
		</tr>
		<tr>
			<td bgcolor="orange">����</td>
			<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="70">���ε�</td>
			<td><input type="file" name="uploadFile" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="�� �۵��"/>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	<a href="getBoardList.do">�� ��� ����</a>
	</center>
</body>
</html>