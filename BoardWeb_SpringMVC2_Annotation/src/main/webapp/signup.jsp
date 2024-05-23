<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="EUC-KR">
    <title>회원 가입</title>
    <link rel="stylesheet" href="resources/user_styles.css">
    <style>
        table {
            margin: 0 auto;
        }
    </style>
    <script>
    /* js코드로 이메일 앞/뒤부분 합쳐서 db에 보내기 -> 현재 2개로 나뉘어져있어서 db에 이메일정보가 저장이 안됨 */
    	
    	// 1. 분할태그 합치기
        function combineFields() {
        	// 1)이메일 태그 합치기
            var emailId = document.getElementsByName("emailId")[0].value;
            var emailAddr = document.getElementsByName("emailAddr")[0].value;
            var emailAddrSelect = document.getElementsByName("emailAddrSelect")[0].value;
            
            if(emailAddrSelect !== "") {
                emailAddr = emailAddrSelect;
            }
            
            var fullEmail = emailId + "@" + emailAddr;
            document.getElementsByName("u_email")[0].value = fullEmail;
            
         	// 2)핸드폰 태그 합치기
         	var tel1 = document.getElementsByName("tel_1")[0].value;
            var tel2 = document.getElementsByName("tel_2")[0].value;
            var tel3 = document.getElementsByName("tel_3")[0].value;
            var fullPhone = tel1 + "-" + tel2 + "-" + tel3;
            document.getElementsByName("u_phone")[0].value = fullPhone;
        }
    
    	// 2. 중복체크(.. 여기에 js, java, html 3개있음.. 어지럽다..)
    	var isIdAvailable = false;
    	
        function checkDuplicateId() {
            var userId = document.getElementsByName("u_id")[0].value;
            if(userId === "") {
                alert("아이디를 입력해주세요.");
                return;
            }

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "checkId.do", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function() {
                if(xhr.readyState == 4 && xhr.status == 200) {
                    var response = xhr.responseText;
                    if(response == "available") {
                        alert("사용 가능한 아이디입니다.");
                        isIdAvailable = true;
                    } else {
                        alert("이미 사용 중인 아이디입니다.");
                        isIdAvailable = false;
                    }
                }
            };
            xhr.send("u_id=" + encodeURIComponent(userId));
        }
        
        // 3. id중복체크해서, 중복이면 아예 폼제출 못하도록!
        function validateForm(event) {
            if (!isIdAvailable) {
                alert("아이디 중복 체크를 통과하지 못했습니다. 다른 아이디를 사용해주세요.");
                event.preventDefault();
            } else {
                combineFields();
            }
        }
     
    </script>
</head>

<body>
<!-- <form method="post" action="signup.do" target="_self" onsubmit="combineFields()"> -->
<form method="post" action="signup.do" target="_self" onsubmit="validateForm(event)">
    <table border="0" width="650">
        <tr>
            <th colspan="2">
                <h1>회원가입</h1>
            </th>
        </tr>
        <tr>
            <td width="150">이름</td>
            <td><input type="text" name="u_name" size="10"></td>
        </tr>
        <tr>
            <td>성별</td>
            <td>
                <input type="radio" name="u_gender" value="남" checked>남
                <input type="radio" name="u_gender" value="여">여
            </td>
        </tr>
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="u_id" size="10" max="20">
                <input type="button" value="중복확인" name="idconfirm" onclick="checkDuplicateId()">
                <!-- <input type="button" value="중복확인" name="idconfirm" onclick=""> -->
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="u_pw" size="10" max="20"></td>
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="u_pwc" size="10" max="20"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td>
                <input type="text" name="u_addr" size="50" max="100">
                <input type="button" name="addrSearch" value="주소찾기" onclick="">
            </td>
        </tr>
        <tr>
            <td>이메일</td>
            <td>
            	<div class="inline-inputs">
	                <input type="text" name="emailId" size="10" max="20">@
	                <input type="text" name="emailAddr" size="15" max="20">
	                <select name="emailAddrSelect">
	                    <option value="" selected>직접입력
	                    <option value="naver.com">naver.com
	                    <option value="daum.net">daum.net
	                    <option value="gmail.com">gmail.com
	                    <option value="nate.com">nate.com
	                    <option value="yahoo.com">yahoo.com
	                </select>
	                <!-- Hidden field to store the combined email -->
	                <input type="hidden" name="u_email">
                </div>
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td>
            	<div class="inline-inputs">
	                <select name="tel_1" size="1">
	                    <option value="010" selected>010
	                    <option value="011">011
	                    <option value="016">016
	                    <option value="017">017
	                    <option value="018">018
	                    <option value="019">019
	                </select>
	                -
	                <input type="text" name="tel_2" size="6" max="10">
	                -
	                <input type="text" name="tel_3" size="6" max="10">
	                <!-- Hidden field to store the combined phone number -->
	                <input type="hidden" name="u_phone">
                </div>
            </td>
        </tr>
        <tr>
            <td>취미</td>
            <td>
                <input type="checkbox" name="u_hobby" value="여행" checked>여행
                <input type="checkbox" name="u_hobby" value="쇼핑">쇼핑
                <input type="checkbox" name="u_hobby" value="게임">게임
                <input type="checkbox" name="u_hobby" value="축구">축구
                <input type="checkbox" name="u_hobby" value="음악듣기">음악듣기
                <input type="checkbox" name="u_hobby" value="드라이브">드라이브
                <input type="checkbox" name="u_hobby" value="기타">기타
            </td>
        </tr>
        <tr>
            <td>자기소개</td>
            <td>
                <textarea name="u_introduce" rows="10" cols="60"></textarea>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="가입하기"> <input type="reset" value="다시작성">
            </th>
        </tr>
    </table>
</form>
</body>

</html>