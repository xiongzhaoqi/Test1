window.onload = function() {
	document.forms["input"].elements["id"].focus();
}
function check() {
	old = document.getElementById("oldpassword").value;
	id = document.getElementById("id").value;
	password = document.getElementById("password").value;

	if ("" == id) {
		alert("编号不能为空！");
		return false;
	} else if ("" == password) {
		alert("密码不能为空！");
		return false;
	} else if (isNaN(id)) {
		alert("编号只能输入数字！")
		return false;
	} else {
		return true;
	}
}

function check1() {
	oldpassword = document.getElementById("oldpassword").value;
	textpassword = document.getElementById("textpassword").value;
	second = document.getElementById("second").value;

	if ("" == oldpassword) {
		alert("旧密码不能为空！");
		return false;
	} else if ("" == textpassword) {
		alert("新密码不能为空！");
		return false;
	} else if (textpassword != second) {
		alert("两次输入的密码不一致！");
		return false;
	} else {
		return true;
	}
}
function check2() {
	alert("请登录！");
	return false;
}

function check3() {

	eid = document.getElementById("eid").value;
	name = document.getElementById("name").value;
	password = document.getElementById("password").value;

	if ("" == eid) {
		alert("员工号不能为空！");
		return false;
	} else if (isNaN(eid)) {
		alert("员工号只能输入数字！")
		return false;
	} else if ("" == name) {
		alert("姓名不能为空！");
		return false;
	} else if ("" == password) {
		alert("密码不能为空！");
		return false;
	} else {
		return true;
	}
}
