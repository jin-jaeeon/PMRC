<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<div>
			<img class="profileImg"
				src="resources/img/${sessionScope.loginMember.p_photo }">
			<span class="loginMberTxt">${sessionScope.loginMember.p_user }(${sessionScope.loginMember.p_name })</span>
			<span class="loginMberTxt">님 안녕하세요.</span>
		</div>
		<div id="welcomeBtnBox">
		<form action="member.info">
			<button class="memberBtn">회원정보</button>
		</form>
		<form action="member.logout" method="post">
		<button class="memberBtn">로그아웃</button>
		</form>
		</div>
</body>
</html>