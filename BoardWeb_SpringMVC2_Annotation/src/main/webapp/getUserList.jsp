<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<meta name="Generator" content="Edit~">
<title>��ü ���� ��ȸ</title>

<link rel="stylesheet" href="resources/userlist_styles.css">
</head>

<body>
<h1>ȸ�� ����Ʈ</h1>
<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">��ȣ(seq)</th>
			<th bgcolor="orange" width="200">�̸�</th>
			<th bgcolor="orange" width="150">���̵�</th>
			<th bgcolor="orange" width="150">����</th>
			<th bgcolor="orange" width="150">��ȭ��ȣ</th>
			<th bgcolor="orange" width="150">�̸���</th>
			<th bgcolor="orange" width="400">�ּ�</th>
		</tr>
		<c:forEach items="${userList }" var="user">
		<tr>
		
			<td>${user.u_seq}</td>
			<!-- ������ ��, getUser()�޼��带 �����;� �ϴµ�, �̰� id,pw�� �־�� �� - login�� �� ���°Ŵϱ�
				- (setString) -> �ٵ�? ������.. �׳� �޼��� �ϳ� �� ������. �Ʒ� �±� ���!
				- !!!!�׷��� �ϴ�, &�� ���� 2�� �ִ°Ŵ� ����ص���(request������ �ϴ°��Ӥ���. id,pw���� 2�� �־!) !!!!!!!!
			<td align="left"><a href="getUser.do?u_id=${user.u_id}&u_pw=${user.u_pw}">${user.u_name}</a></td> 
			-->
			<td align="left"><a href="getUser.do?u_seq=${user.u_seq}">${user.u_name}</a></td>
			<td>${user.u_id}</td>
			<td>${user.u_gender}</td>
			<td>${user.u_phone}</td>
			<td>${user.u_email}</td>
			<td>${user.u_addr}</td>
		</tr>
		</c:forEach>
		
	</table>	
</body>
</html>