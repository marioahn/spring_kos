<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// ���� ���������̴�. ���⼭, �������� ������ �� �� - admin���忡�� �Ѵٰ� ��������
%>

<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��</title>
<link rel="stylesheet" href="resources/user_styles.css">
</head>
<body>
	<center>
	<h1>���� ��</h1>
	<hr>
	<form action="updateUser.do" method="post">
	<!-- getUserList.jsp���� pk�� u_seq�� ã�Ƽ� �����Ծ�������. �ٵ� �Ʒ��ڵ� �ʿ��Ѱ� �� �ִ°���???????????  -->
	<input name="u_seq" type="hidden" value="${user.u_seq}" />
	<table border="1" cellpadding="0" cellspacing="0">
	<!-- ������ �ٲ� �� �ִ°�? - UserDAO.updateUser()�޼��忡�� ��� setString�ߴ��� ���� -->
		<tr>
			<td bgcolor="orange" width="70">�̸�</td>
			<td>${user.u_name}</td>
		</tr>
		<tr>
			<td bgcolor="orange">���</td>
			<td align="left"><input name="u_pw" type="text" value="${user.u_pw}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">��� Ȯ��</td>
			<td align="left"><input name="u_pwc" type="text" value="${user.u_pwc}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">�ּ�</td>
			<td align="left"><input name="u_addr" type="text" value="${user.u_addr}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">��ȭ��ȣ</td>
			<td align="left"><input name="u_phone" type="text" value="${user.u_phone}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">���</td>
			<td align="left"><input name="u_hobby" type="text" value="${user.u_hobby}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">�ڱ� �Ұ�</td>
			<td align="left"><textarea name="u_introduce" cols="40" rows="10">${user.u_introduce}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="ȸ�� ���� ����"/>
				<!-- <button type="button" onclick="location.href='deleteUser.do'">ȸ�� ����</button>
				�̷��� �ϸ� �ȵ���. ��.��.�Խù��� ������ �������� ���� seq������ �� �Ѿ�ϱ� controller��! -->
				<%-- <a href="deleteUser.do?id=${user.u_id}">ȸ�� ����</a> --%>
				<button type="button" onclick="location.href='deleteUser.do?u_seq=${user.u_seq}'">ȸ�� ����</button>
				<button type="button" onclick="location.href='getUserList.do'">��ü ȸ�� ���</button>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	
	</center>
</body>
</html>