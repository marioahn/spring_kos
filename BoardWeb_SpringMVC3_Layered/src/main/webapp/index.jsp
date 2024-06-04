<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="EUC-KR">
<title>Main Page</title>
<!-- <link rel="stylesheet" href="resources/index_styles.css"> -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<center>
		<h1>BoardWeb</h1>
        <hr>
        <a href="login.do" class="btn btn-primary btn-lg mb-3">로그인</a><br>
        <a href="signup.jsp" class="btn btn-success btn-lg mb-3">회원가입</a><br>
        <a href="getBoardList.do" class="btn btn-info btn-lg mb-3">글 목록 바로가기</a><br>
        <a href="getUserList.do" class="btn btn-warning btn-lg mb-3">회원 목록 바로가기</a>
        <hr>
	</center>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>