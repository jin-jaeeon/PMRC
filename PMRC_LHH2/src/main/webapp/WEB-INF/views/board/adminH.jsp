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
<body onload="pagingNumColor();">
		<table id="postTbl">
			<tr>
				<td align="center" class="boardNav">선택</td>
				<td align="center" class="boardNav">회원 아이디</td>
				<td align="left" class="boardNav postTitle">회원 이름 </td>
				<td align="center" class="boardNav">회원 생년월일</td>
				<td align="center" class="boardNav">회원 등급</td>
			</tr>
			<c:forEach var="m" items="${members }">
				<tr id="postItems">
					<td align="center" id="checkbox"><input type="checkbox" name="p_grade" value="${m.p_user }">
					<td align="center">${m.p_user }</td>
					<td class="postTitle" align="left">${m.p_name }</td>
					<td align="right">
						<fmt:formatDate value="${m.p_birthday }" pattern="yyyy-MM-dd"/>
					</td>
					<td align="center">${m.p_grade }</td>
				</tr>
			</c:forEach>
		</table>

	<form action="member.search" name="postSearchForm"
		onsubmit="return postSearchCheck();">
		<input name="search" maxlength="10">
		<button>검색</button>
	</form>

	<div id="pagingBox">
		<input type="hidden" value="${page }" id="toChooseCurrentPage">
		<c:forEach var="p" begin="1" end="${pageCount }">
			<a href="go.adminP?page=${p }" class="pagingNum">${p }</a>
		</c:forEach>
	</div>
</body>
</html>