<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<meta name="Generator" content="Edit~">
<title>전체 유저 조회</title>

<link rel="stylesheet" href="resources/userlist_styles.css">
</head>

<body>
<h1>회원 리스트</h1>
<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호(seq)</th>
			<th bgcolor="orange" width="200">이름</th>
			<th bgcolor="orange" width="150">아이디</th>
			<th bgcolor="orange" width="150">성별</th>
			<th bgcolor="orange" width="150">전화번호</th>
			<th bgcolor="orange" width="150">이메일</th>
			<th bgcolor="orange" width="400">주소</th>
		</tr>
		<c:forEach items="${userList }" var="user">
		<tr>
			<td>${user.u_seq}</td>
			<td>${user.u_name}</td>
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