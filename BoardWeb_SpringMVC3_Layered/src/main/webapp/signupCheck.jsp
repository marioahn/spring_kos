<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <title>ȸ�� ����</title>
</head>
<!-- <script src="js/signupCheck.js"></script> -->
<script>
// js�ڵ� ���⿡ ���� ������, ��ó�� src=��� ����ְ�, js���� ���� ���� js���� ���� ������ ��-�� ���!
// �ٵ�, js���� �� ������ �� �ڵ� ������ ����� ��� �� ��
function joinform_check() {
  //������ ����ֱ�
  var uid = document.getElementById("uid");
  var pwd = document.getElementById("pwd");
  var repwd = document.getElementById("repwd");
  var uname = document.getElementById("uname");
  var female = document.getElementById("female");
  var male = document.getElementById("male");
  var mobile = document.getElementById("mobile");
  var email_id = document.getElementById("email_id");
  var agree = document.getElementById("agree");

  if (uid.value == "") { //�ش� �Է°��� ���� ��� ������: if(!uid.value)
    alert("���̵� �Է��ϼ���.");
    uid.focus(); //focus(): Ŀ���� �����̴� ����, blur(): Ŀ���� ������� ����
    return false; //return: ��ȯ�ϴ� return false:  �ƹ��͵� ��ȯ���� ���ƶ� �Ʒ� �ڵ���� �ƹ��͵� �������� ����
  };

  if (pwd.value == "") {
    alert("��й�ȣ�� �Է��ϼ���.");
    pwd.focus();
    return false;
  };

  //��й�ȣ ������+����+Ư������(8~25�ڸ� �Է�) ���Խ�
  var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

  if (!pwdCheck.test(pwd.value)) {
    alert("��й�ȣ�� ������+����+Ư������ �������� 8~25�ڸ� ����ؾ� �մϴ�.");
    pwd.focus();
    return false;
  };

  if (repwd.value !== pwd.value) {
    alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
    repwd.focus();
    return false;
  };

  if (uname.value == "") {
    alert("�̸��� �Է��ϼ���.");
    uname.focus();
    return false;
  };

  if (!female.checked && !male.checked) { //�Ѵ� ��üũ��
    alert("������ ������ �ּ���.");
    female.focus();
    return false;
  }

  var reg = /^[0-9]+/g; //���ڸ� �Է��ϴ� ���Խ�

  if (!reg.test(mobile.value)) {
    alert("��ȭ��ȣ�� ���ڸ� �Է��� �� �ֽ��ϴ�.");
    mobile.focus();
    return false;
  }

  if (email_id.value == "") {
    alert("�̸��� �ּҸ� �Է��ϼ���.");
    email_id.focus();
    return false;
  }

  if (!agree.checked) { //üũ�ڽ� ��üũ��
    alert("��� ���Ǹ� üũ�ϼ���.");
    agree.focus();
    return false;
  }

  //�Է� �� ����
  document.join_form.submit(); //��ȿ�� �˻��� ����Ʈ   
}

//���̵� �ߺ�üũ �˾�â(���� ���鹮��)
function id_check() {
  //window.open("�˾��� ���� ���", "�˾��� ���� �̸�", "�ɼ�");
  window.open("", "", "width=600, height=200, left=200, top=100");
}

//�̸��� �ɼ� ������ �ּ� �ڵ� �ϼ�
function change_email() {
  var email_add = document.getElementById("email_add");
  var email_sel = document.getElementById("email_sel");

  //���� ����� �ɼ��� ������ �� ���ϱ�
  var idx = email_sel.options.selectedIndex;
  var val = email_sel.options[idx].value;

  email_add.value = val;
}

//�����ȣ �˻� �˾�â(���� ���鹮��)
function search_address() {
  window.open("", "b", "width=600, height=300, left=200, top=100");
}
</script>
<body>
	<form name="join_form" action="memberInput.do" method="post">
  		<div>
    		<label>���̵�<input type="text" name="udi" id="uid"></label>
    		<button type="button" onclick="id_check();">�ߺ�Ȯ��</button>
  		</div>
		<div><label>��й�ȣ<input type="password" name="pwd" id="pwd" placeholder="������+����+Ư������ ����"></label></div>
		<div><label>��й�ȣ ��Ȯ��<input type="password" name="repwd" id="repwd"></label></div>
		<div><label>�̸�<input type="text" name="uname" id="uname"></label></div>
		<div>
		  <label>
		    <!--������� �������� option �����̾����� ����� text type���� ���� �߼�-->
		    �������<input type="text" name="yy" id="yy" placeholder="��(4��)" maxlength="4">
		    <select name="mm" id="mm">
		      <option value="">��</option>
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
		  <input type="text" name="dd" id="dd" placeholder="��" maxlength="2">
		</div>
		<div>
		  <!--radio��ư�� �� ���� �ϳ��� �����Ϸ��� name���� ���� �����
		       radio ��ư�� DB����� ����� ���� value="" ���� ���� �־ DB ���� ���۵�
		       radio ��ư�� id���� �ϳ��� ������ �����ϹǷ� radio ��츸 id�� �ٸ��� ����-->
		  ����<input type="radio" value="F" name="gender" id="female">��
		  <!--"��"�� �̸� üũ������ ���<input type="radio" value="F" name="sex" id="female" checked>��-->
		  <input type="radio" value="M" name="gender" id="male">��
		</div>
		<div>
		  <label>��ȭ��ȣ<input type="tel" name="mobile" id="mobile"> ex "-"���� ���ڸ� �Է�</label>
		</div>
		<div>
		  <label>�̸���<input type="text" name="email_id" id="email_id">@</label>
		  <input type="text" name="email_add" id="email_add">
		  <select name="email_sel" id="email_sel" onchange="change_email();">
		    <!--onchage: select�ȿ� �ִ� �ɼǵ��� ���� �ٲ����� ����� ����
		        onclick�� ���ϴ� ����: Ű���� ����ڴ� click�� �Ҽ� �����Ƿ�-->
		    <option value="">�����Է�</option>
		    <option value="naver.com">naver</option>
		    <option value="gmail.com">gmail</option>
		    <option value="nate.com">nate</option>
		  </select>
		</div>
		<div>
		  <label>�ּ�<input type="text" name="postal_code" id="postal_code"></label>
		  <button type="button" onclick="search_address();">�˻�</button>
		</div>
		<div>
		  <label>�⺻�ּ�<input type="text" name="addr1" id="addr1" size="30"></label>
		</div>
		<div>
		  <label>���ּ�<input type="text" name="addr2" id="addr2" size="30"></label>
		</div>
		<div>
		  <label>�������<input type="checkbox" value="Y" name="agree" id="agree">����� �����մϴ�.</label>
		</div>
		<div class="join_btn">
		  <button type="button" onclick="history.back();">������������</button>
		  <!-- (window����).history.back �ڷΰ���/history.forward �����ΰ���-->
		  <button type="button" onclick="joinform_check();">�����ϱ�</button>
		  <!-- �Էµ� ��쿡 ���� �ٸ��� �׼ǵǸ� button����, �Է� �� ��� ���� ������ ������� submit -->
		  <!-- type�� submit���� �Ͽ� �����ϱ⸦ ��������, script���� �Լ��� ����� �����ϱ⸦ �� button onclick���� �Լ��� �ҷ��� �Լ��ȿ� ������ �ִ� ��� return false;-->
		</div>
	</form>
</body>
</html>