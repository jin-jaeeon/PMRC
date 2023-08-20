<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/logInJs.js"></script>
<script type="text/javascript" src="resources/js/kakaoAPI.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="resources/js/pageMoveControll.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<script type="text/javascript">
	Kakao.init('7c5e066dfe350f0f253d1f6cc25b7ec2'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			success : function(response) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						console.log(response)
					},
					fail : function(error) {
						console.log(error)
					},
				})
			},
			fail : function(error) {
				console.log(error)
			},
		})
	}
	//카카오로그아웃
</script>
<script type="text/javascript">
	window.onpageshow = function(event) {
		if (event.persisted
				|| (window.performance && window.performance.navigation.type == 2)) {
			// Back Forward Cache로 브라우저가 로딩될 경우 혹은 브라우저 뒤로가기 했을 경우
			// 이벤트 추가하는 곳
			location.href = '/sproject/index.go';
		}
	}
</script>
<script type="text/javascript">
<script type="text/javascript">
window.history.forward();
function noBack(){
    window.history.forword();
}
</script>
<!-- <script type="text/javascript">
 window.history.forward();
 function noBack(){window.history.forward();}
</script> -->
<title>PMRC</title>
</head>

<body>
	<div id="outerBox">
		<table id="loginBox">
			<tr>
				<td class="tdNav" colspan="3">
					<p class="formTitle">LogIn</p>
				</td>
			</tr>
			<form action="member.login" method="post">
				<tr>
					<td class="tdNav" colspan="3"><input type="text" name="p_user"
						id="id" placeholder="Enter ID" class="tdInput"></td>
				</tr>
				<tr>
					<td class="tdNav" colspan="3"><input type="password"
						name="p_password" placeholder="Enter PassWord" class="tdInput">
					</td>
				</tr>
				<tr>
					<td class="tdNav" colspan="3">
						<button id="loginBtn">로그인</button>
			</form>
			</td>
			</tr>
			<tr>
				<td colspan="3">
					<div id="loginTblLinkBox">
						<div class="loginTblLinkBoxInnerBox">
							 아이디 저장<input type="checkbox" id="checkId" name="checkId">
						</div>
						<div class="loginTblLinkBoxInnerBox">
							<a class="linkHover" href="join.go">회원가입</a>
						</div>
						<div class="loginTblLinkBoxInnerBox">
							<span id="popupBtn" class="optionModifyBtn" onclick="openPopUp()">아이디 찾기</span>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td class="tdNav" colspan="3"><a href="javascript:void(0)">
						<img class="anotherLogin" alt=""
						src="data:image/png;base64,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"
						onclick="kakaoLogin();">
				</a></td>

			</tr>
		</table>
	</div>
</body>
</html>
