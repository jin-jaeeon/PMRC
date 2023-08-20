<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<link rel="stylesheet" type="text/css" href="resources/css/member.css">
<link rel="stylesheet" type="text/css" href="resources/css/boardH.css">
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
<link rel="stylesheet" type="text/css" href="resources/css/movie.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/pageMoveControll.js"></script>
<meta charset="UTF-8">
<title>플랫폼 양성과정 홈페이지</title>

</head>
<body>
	<div id="outerArea">
		<div id="imageArea">
			<div id="siteTitleArea">
				<div id="siteTitleArea2">
					<a href="index.go" id="titleHomeLink">PMRC</a><br>
				</div>
				<div id="siteMenuArea">
					<jsp:include page="${lp }"></jsp:include>
				</div>
			</div>
			<div class="container">
				<ul class="nav">
					<li><img alt="이미지 없음" src="resources/img/menu3.png"
						id="menuIcon">
						<ul class="sub sub1">
							<li><a href="go.genre">장르별 Top10</a></li>
							<li><a href="go.sns">자유 게시판</a></li>
							<li><a href="go.movie">영화 목록</a></li>
						<c:if test="${sessionScope.loginMember.p_grade == 'True'}">
							<li><a href="go.admin">관리자</a></li>
						</c:if>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="siteContentArea">
			<jsp:include page="${cp }"></jsp:include>
		</div>
	</div>
</body>
</html>