// 1. 최종적으로 utf-8쓸거
// 2. 한글 안쓸거

// 웹 유효성검사할때마다 쓸 수 있게
// 최대한 일반적으로
// 부정적(잘못됐으면 true) or 긍정적

// <input> 넣
// 안썼으면 true, 썼으면 false
function isEmpty(input) {
	return !input.value;
}

// <input> 넣
// 한글/특수문자가 있으면 true, 없으면 false
//		@ . _ - 는 괜찮
function containsHS(input) {
	var ok = "1234567890@-_.qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	for (var i = 0; i < input.value.length; i++){
		if (ok.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
}

// <input>, 최소글자수 넣
// 그거보다 글자수가 적으면 true, 아니면 false
function lessThan(input, len) {
	return input.value.length < len;
}

// <input>, 문자열세트를 넣
// 그 문자열세트에서 하나도 안들어있으면 true, 있으면 false
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input> x 2 넣
// 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return input1.value != input2.value;
}

// <input> 넣
// 숫자가 아니면 true, 정상숫자면 false
function isNotNumber(input) {
	return (input.value.indexOf(" ") != -1 || isNaN(input.value));
}

// <input>, 확장자 넣
// 그 파일이 아니면 true, 그거면 false
function isNotType(input, type) {
	// file타입 <input>은 
	// ~~~.value : 선택한 파일명이 문자열로 나옴
	type = "." + type;
	return input.value.toLowerCase().indexOf(type) == -1;
}




