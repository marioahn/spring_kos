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
	<div class="button-container">
        <a href="index.jsp" class="back-button">메인 페이지로 돌아가기</a>
    </div>
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
			<!-- 수정할 때, getUser()메서드를 가져와야 하는데, 이건 id,pw가 있어야 함 - login할 때 쓰는거니까
				- (setString) -> 근데? 개위험.. 그냥 메서드 하나 더 만들자. 아래 태그 노노!
				- !!!!그래도 일단, &로 조건 2개 넣는거는 기억해두자(request저렇게 하는거임ㅇㅇ. id,pw정보 2개 넣어서!) !!!!!!!!
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