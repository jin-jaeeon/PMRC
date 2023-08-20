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
				<td align="center" class="boardNav">글 번호</td>
				<td align="left" class="boardNav postTitle">제목</td>
				<td align="center" class="boardNav">작성자</td>
				<td align="center" class="boardNav">작성일자</td>
				<td align="center" class="boardNav">조회수</td>
			</tr>
			<c:forEach var="p" items="${posts }">
				<tr id="postItems">
					<td align="center">${p.pb_no }</td>
					<td class="postTitle" align="left"><a id="pb_title"
						href="/sproject/goPost?pageDetail=${p.pb_no }">${p.pb_title }</a>
					</td>
					<td align="center">${p.pb_writer }</td>
					<td align="right">
						<fmt:formatDate value="${p.pb_date }" pattern="yyyy-MM-dd"/>
					</td>
					<td align="right">
						<!-- 조회 수 --> ${p.pb_count }
					</td>
				</tr>
			</c:forEach>
		</table>

	<div id="pagingBox">
		<input type="hidden" value="${page }" id="toChooseCurrentPage">
		<c:forEach var="p" begin="1" end="${pageCount }">
			<a href="go.snsP?page=${p }" class="pagingNum">${p }</a>
		</c:forEach>
	</div>


	<form action="post.search" name="postSearchForm"
		onsubmit="return postSearchCheck();">
		<input name="search" maxlength="10">
		<button>검색</button>
	</form>
	<span><a href="go.boardWrite" role="button" id="writeBtn">게시물 작성</a></span>
</body>
</html>