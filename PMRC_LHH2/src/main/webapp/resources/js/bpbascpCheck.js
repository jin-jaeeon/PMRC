function drUploadCheck(f) {
	var titleField = f.bd_title;	var fileField = f.bd_file;

	if (isEmpty(titleField) || isEmpty(fileField)) {
		alert("?");
		titleField.value = "";		fileField.value = "";
		titleField.focus();
		return false;
	}
	return true;
}

function joinCheck() {
	var idField = document.joinForm.p_user;
	var pwField = document.joinForm.p_password;
	var pwChkField = document.joinForm.p_chk;
	var nameField = document.joinForm.p_name;
	var photoField = document.joinForm.bm_photo;

	if (isEmpty(idField) 
			|| containsHS(idField) 
			|| $("#joinID").css("color") == "rgb(255, 0, 0)") {
		alert("올바른 ID를 입력하시오.");
		idField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(pwField) || notContains(pwField, "1234567890")
			|| notEquals(pwField, pwChkField)) {
		alert("비밀번호가 일치하지 않습니다.");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	}
	if (isEmpty(nameField)) {
		alert("이름을 입력하시오.");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	
	if (isEmpty(photoField)
			|| (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(
					photoField, "jpg"))) {
		alert("프로필 사진을 선택하시오.");
		photoField.value = "";
		return false;
	}
	return true;
}

function loginCheck() {
	var idField = document.loginForm.bm_id;
	var pwField = document.loginForm.bm_pw;

	if (isEmpty(idField) || isEmpty(pwField)) {
		alert("?");
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(photoField)
			|| (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(
					photoField, "jpg"))) {
		alert("프로필 사진을 선택하시오.");
		photoField.value = "";
		return false;
	}
	return true;
}

function memberUpdateCheck() {
	var pwField = document.memberUpdateForm.p_password;
	var pwChkField = document.memberUpdateForm.p_pwChk;
	var photoField = document.memberUpdateForm.p_photo;
	
	if (isEmpty(pwField) || notContains(pwField, "1234567890")
			|| notEquals(pwField, pwChkField)) {
		alert("비밀번호가 일치하지 않습니다.");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	}
}

function snsPostWriteCheck() {
	var txtField = document.snsPostWriteForm.bs_txt;
	if (isEmpty(txtField)) {
		alert("?");
		return false;
	}
	return true;
}
// <form> x 10개가 snsReplyWriteCheck에 연결된 상태
// f : submit시도하는 그 <form> -> snsReplyWriteCheck()를 호출한 <form>
function snsReplyWriteCheck(f) {
	// 이html.이름이 snsReplyWriteForm인 <form>.이름이 bsr_txt인 <input>
	// 이름이 snsReplyWriteForm인게 10개...
	// var txtField = document.snsReplyWriteForm.bsr_txt;
	var txtField = f.bsr_txt;
	if (isEmpty(txtField)) {
		alert("?");
		txtField.focus();
		return false;
	}
	return true;
}
function snsSearchCheck() {
	var searchField = document.snsSearchForm.search;
	if (isEmpty(searchField)) {
		alert("?");
		return false;
	}
	return true;
}
