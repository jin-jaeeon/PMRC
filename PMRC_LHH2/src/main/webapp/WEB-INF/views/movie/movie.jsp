<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="movieOuterBox">
		<div id="movieInnerBox1">
			<c:forEach var=m items="${Movies }">
				<div class="dd">
					<div>
						<img alt="" src="${m.pm_url }">
					</div>
					<div>
						<img alt="" src="${m.pm_url }">
					</div>
					<div>
						<img alt="" src="${m.pm_url }">
					</div>
				</div>
			</c:forEach>
		</div>
		<div id="movieInnerBox2">
			<c:forEach var="p" begin="1" end="${pageCount }">
				<a href="movie.searchP?page=${p }">${p }</a>
			</c:forEach>
		</div>


		<div id="movieInnerBox3">
			<form action="movie.search">
				<input name="search">
				<button>검색</button>
			</form>
		</div>
	</div>
</body>
</html>