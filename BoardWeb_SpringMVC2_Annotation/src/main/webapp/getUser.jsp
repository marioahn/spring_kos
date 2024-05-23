<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 유저 상세페이지이다. 여기서, 유저정보 수정도 할 것 - admin입장에서 한다고 생각하자
%>

<!DOCTYPE html public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose/dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>유저 상세</title>
<link rel="stylesheet" href="resources/user_styles.css">
</head>
<body>
	<center>
	<h1>유저 상세</h1>
	<hr>
	<form action="updateUser.do" method="post">
	<!-- getUserList.jsp에서 pk인 u_seq로 찾아서 가져왔었음ㅇㅇ. 근데 아래코드 필요한가 왜 있는거지???????????  -->
	<input name="u_seq" type="hidden" value="${user.u_seq}" />
	<table border="1" cellpadding="0" cellspacing="0">
	<!-- 무엇을 바꿀 수 있는가? - UserDAO.updateUser()메서드에서 어떤거 setString했는지 ㄱㄱ -->
		<tr>
			<td bgcolor="orange" width="70">이름</td>
			<td>${user.u_name}</td>
		</tr>
		<tr>
			<td bgcolor="orange">비번</td>
			<td align="left"><input name="u_pw" type="text" value="${user.u_pw}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">비번 확인</td>
			<td align="left"><input name="u_pwc" type="text" value="${user.u_pwc}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">주소</td>
			<td align="left"><input name="u_addr" type="text" value="${user.u_addr}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">전화번호</td>
			<td align="left"><input name="u_phone" type="text" value="${user.u_phone}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">취미</td>
			<td align="left"><input name="u_hobby" type="text" value="${user.u_hobby}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">자기 소개</td>
			<td align="left"><textarea name="u_introduce" cols="40" rows="10">${user.u_introduce}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원 정보 수정"/>
				<!-- <button type="button" onclick="location.href='deleteUser.do'">회원 삭제</button>
				이렇게 하면 안되지. 어.느.게시물을 삭제할 것인지에 대한 seq정보가 안 넘어가니까 controller로! -->
				<%-- <a href="deleteUser.do?id=${user.u_id}">회원 삭제</a> --%>
				<button type="button" onclick="location.href='deleteUser.do?u_seq=${user.u_seq}'">회원 삭제</button>
				<button type="button" onclick="location.href='getUserList.do'">전체 회원 목록</button>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	
	</center>
</body>
</html>