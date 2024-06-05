<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <title>회원 가입</title>
</head>
<!-- <script src="js/signupCheck.js"></script> -->
<script>
// js코드 여기에 쓰기 싫으면, 위처럼 src=경로 적어넣고, js폴더 만들어서 관련 js폴더 몰아 넣으면 훨-씬 깔끔!
// 근데, js파일 안 먹힘ㅠ 걍 코드 가져다 여기다 써야 할 듯
function joinform_check() {
  //변수에 담아주기
  var uid = document.getElementById("uid");
  var pwd = document.getElementById("pwd");
  var repwd = document.getElementById("repwd");
  var uname = document.getElementById("uname");
  var female = document.getElementById("female");
  var male = document.getElementById("male");
  var mobile = document.getElementById("mobile");
  var email_id = document.getElementById("email_id");
  var agree = document.getElementById("agree");

  if (uid.value == "") { //해당 입력값이 없을 경우 같은말: if(!uid.value)
    alert("아이디를 입력하세요.");
    uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
    return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
  };

  if (pwd.value == "") {
    alert("비밀번호를 입력하세요.");
    pwd.focus();
    return false;
  };

  //비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
  var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

  if (!pwdCheck.test(pwd.value)) {
    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
    pwd.focus();
    return false;
  };

  if (repwd.value !== pwd.value) {
    alert("비밀번호가 일치하지 않습니다..");
    repwd.focus();
    return false;
  };

  if (uname.value == "") {
    alert("이름을 입력하세요.");
    uname.focus();
    return false;
  };

  if (!female.checked && !male.checked) { //둘다 미체크시
    alert("성별을 선택해 주세요.");
    female.focus();
    return false;
  }

  var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

  if (!reg.test(mobile.value)) {
    alert("전화번호는 숫자만 입력할 수 있습니다.");
    mobile.focus();
    return false;
  }

  if (email_id.value == "") {
    alert("이메일 주소를 입력하세요.");
    email_id.focus();
    return false;
  }

  if (!agree.checked) { //체크박스 미체크시
    alert("약관 동의를 체크하세요.");
    agree.focus();
    return false;
  }

  //입력 값 전송
  document.join_form.submit(); //유효성 검사의 포인트   
}

//아이디 중복체크 팝업창(현재 공백문서)
function id_check() {
  //window.open("팝업될 문서 경로", "팝업될 문서 이름", "옵션");
  window.open("", "", "width=600, height=200, left=200, top=100");
}

//이메일 옵션 선택후 주소 자동 완성
function change_email() {
  var email_add = document.getElementById("email_add");
  var email_sel = document.getElementById("email_sel");

  //지금 골라진 옵션의 순서와 값 구하기
  var idx = email_sel.options.selectedIndex;
  var val = email_sel.options[idx].value;

  email_add.value = val;
}

//우편번호 검색 팝업창(현재 공백문서)
function search_address() {
  window.open("", "b", "width=600, height=300, left=200, top=100");
}
</script>
<body>
	<form name="join_form" action="memberInput.do" method="post">
  		<div>
    		<label>아이디<input type="text" name="udi" id="uid"></label>
    		<button type="button" onclick="id_check();">중복확인</button>
  		</div>
		<div><label>비밀번호<input type="password" name="pwd" id="pwd" placeholder="영문자+숫자+특수문자 조합"></label></div>
		<div><label>비밀번호 재확인<input type="password" name="repwd" id="repwd"></label></div>
		<div><label>이름<input type="text" name="uname" id="uname"></label></div>
		<div>
		  <label>
		    <!--생년월일 예전에는 option 형식이었지만 현재는 text type으로 변경 추세-->
		    생년월일<input type="text" name="yy" id="yy" placeholder="년(4자)" maxlength="4">
		    <select name="mm" id="mm">
		      <option value="">월</option>
		      <option value="01">1</option>
		      <option value="02">2</option>
		      <option value="03">3</option>
		      <option value="04">4</option>
		      <option value="05">5</option>
		      <option value="06">6</option>
		      <option value="07">7</option>
		      <option value="08">8</option>
		      <option value="09">9</option>
		      <option value="10">10</option>
		      <option value="11">11</option>
		      <option value="12">12</option>
		    </select>
		  </label>
		  <input type="text" name="dd" id="dd" placeholder="일" maxlength="2">
		</div>
		<div>
		  <!--radio버튼은 둘 중의 하나만 선택하려면 name값을 같게 줘야함
		       radio 버튼은 DB저장과 상관이 없음 value="" 따로 값을 넣어서 DB 값이 전송됨
		       radio 버튼은 id값을 하나만 설정이 가능하므로 radio 경우만 id값 다르게 설정-->
		  성별<input type="radio" value="F" name="gender" id="female">여
		  <!--"여"에 미리 체크되있을 경우<input type="radio" value="F" name="sex" id="female" checked>여-->
		  <input type="radio" value="M" name="gender" id="male">남
		</div>
		<div>
		  <label>전화번호<input type="tel" name="mobile" id="mobile"> ex "-"없이 숫자만 입력</label>
		</div>
		<div>
		  <label>이메일<input type="text" name="email_id" id="email_id">@</label>
		  <input type="text" name="email_add" id="email_add">
		  <select name="email_sel" id="email_sel" onchange="change_email();">
		    <!--onchage: select안에 있는 옵션들의 값이 바꼈을때 명령이 실행
		        onclick을 안하는 이유: 키보드 사용자는 click을 할수 없으므로-->
		    <option value="">직접입력</option>
		    <option value="naver.com">naver</option>
		    <option value="gmail.com">gmail</option>
		    <option value="nate.com">nate</option>
		  </select>
		</div>
		<div>
		  <label>주소<input type="text" name="postal_code" id="postal_code"></label>
		  <button type="button" onclick="search_address();">검색</button>
		</div>
		<div>
		  <label>기본주소<input type="text" name="addr1" id="addr1" size="30"></label>
		</div>
		<div>
		  <label>상세주소<input type="text" name="addr2" id="addr2" size="30"></label>
		</div>
		<div>
		  <label>약관동의<input type="checkbox" value="Y" name="agree" id="agree">약관에 동의합니다.</label>
		</div>
		<div class="join_btn">
		  <button type="button" onclick="history.back();">이전페이지로</button>
		  <!-- (window삭제).history.back 뒤로가기/history.forward 앞으로가기-->
		  <button type="button" onclick="joinform_check();">가입하기</button>
		  <!-- 입력된 경우에 따라서 다르게 액션되면 button으로, 입력 값 상관 없이 무조건 보내기면 submit -->
		  <!-- type을 submit으로 하여 전송하기를 하지말고, script가서 함수를 만들고 전송하기를 함 button onclick으로 함수를 불러옴 함수안에 문제가 있는 경우 return false;-->
		</div>
	</form>
</body>
</html>