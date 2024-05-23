<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="EUC-KR">
    <title>ȸ�� ����</title>
    <link rel="stylesheet" href="resources/user_styles.css">
    <style>
        table {
            margin: 0 auto;
        }
    </style>
    <script>
    /* js�ڵ�� �̸��� ��/�ںκ� ���ļ� db�� ������ -> ���� 2���� ���������־ db�� �̸��������� ������ �ȵ� */
    	
    	// 1. �����±� ��ġ��
        function combineFields() {
        	// 1)�̸��� �±� ��ġ��
            var emailId = document.getElementsByName("emailId")[0].value;
            var emailAddr = document.getElementsByName("emailAddr")[0].value;
            var emailAddrSelect = document.getElementsByName("emailAddrSelect")[0].value;
            
            if(emailAddrSelect !== "") {
                emailAddr = emailAddrSelect;
            }
            
            var fullEmail = emailId + "@" + emailAddr;
            document.getElementsByName("u_email")[0].value = fullEmail;
            
         	// 2)�ڵ��� �±� ��ġ��
         	var tel1 = document.getElementsByName("tel_1")[0].value;
            var tel2 = document.getElementsByName("tel_2")[0].value;
            var tel3 = document.getElementsByName("tel_3")[0].value;
            var fullPhone = tel1 + "-" + tel2 + "-" + tel3;
            document.getElementsByName("u_phone")[0].value = fullPhone;
        }
    
    	// 2. �ߺ�üũ(.. ���⿡ js, java, html 3������.. ��������..)
    	var isIdAvailable = false;
    	
        function checkDuplicateId() {
            var userId = document.getElementsByName("u_id")[0].value;
            if(userId === "") {
                alert("���̵� �Է����ּ���.");
                return;
            }

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "checkId.do", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function() {
                if(xhr.readyState == 4 && xhr.status == 200) {
                    var response = xhr.responseText;
                    if(response == "available") {
                        alert("��� ������ ���̵��Դϴ�.");
                        isIdAvailable = true;
                    } else {
                        alert("�̹� ��� ���� ���̵��Դϴ�.");
                        isIdAvailable = false;
                    }
                }
            };
            xhr.send("u_id=" + encodeURIComponent(userId));
        }
        
        // 3. id�ߺ�üũ�ؼ�, �ߺ��̸� �ƿ� ������ ���ϵ���!
        function validateForm(event) {
            if (!isIdAvailable) {
                alert("���̵� �ߺ� üũ�� ������� ���߽��ϴ�. �ٸ� ���̵� ������ּ���.");
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
                <h1>ȸ������</h1>
            </th>
        </tr>
        <tr>
            <td width="150">�̸�</td>
            <td><input type="text" name="u_name" size="10"></td>
        </tr>
        <tr>
            <td>����</td>
            <td>
                <input type="radio" name="u_gender" value="��" checked>��
                <input type="radio" name="u_gender" value="��">��
            </td>
        </tr>
        <tr>
            <td>���̵�</td>
            <td>
                <input type="text" name="u_id" size="10" max="20">
                <input type="button" value="�ߺ�Ȯ��" name="idconfirm" onclick="checkDuplicateId()">
                <!-- <input type="button" value="�ߺ�Ȯ��" name="idconfirm" onclick=""> -->
            </td>
        </tr>
        <tr>
            <td>��й�ȣ</td>
            <td><input type="password" name="u_pw" size="10" max="20"></td>
        </tr>
        <tr>
            <td>��й�ȣ Ȯ��</td>
            <td><input type="password" name="u_pwc" size="10" max="20"></td>
        </tr>
        <tr>
            <td>�ּ�</td>
            <td>
                <input type="text" name="u_addr" size="50" max="100">
                <input type="button" name="addrSearch" value="�ּ�ã��" onclick="">
            </td>
        </tr>
        <tr>
            <td>�̸���</td>
            <td>
            	<div class="inline-inputs">
	                <input type="text" name="emailId" size="10" max="20">@
	                <input type="text" name="emailAddr" size="15" max="20">
	                <select name="emailAddrSelect">
	                    <option value="" selected>�����Է�
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
            <td>��ȭ��ȣ</td>
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
            <td>���</td>
            <td>
                <input type="checkbox" name="u_hobby" value="����" checked>����
                <input type="checkbox" name="u_hobby" value="����">����
                <input type="checkbox" name="u_hobby" value="����">����
                <input type="checkbox" name="u_hobby" value="�౸">�౸
                <input type="checkbox" name="u_hobby" value="���ǵ��">���ǵ��
                <input type="checkbox" name="u_hobby" value="����̺�">����̺�
                <input type="checkbox" name="u_hobby" value="��Ÿ">��Ÿ
            </td>
        </tr>
        <tr>
            <td>�ڱ�Ұ�</td>
            <td>
                <textarea name="u_introduce" rows="10" cols="60"></textarea>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="�����ϱ�"> <input type="reset" value="�ٽ��ۼ�">
            </th>
        </tr>
    </table>
</form>
</body>

</html>