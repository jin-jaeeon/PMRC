<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
<table id="boardControlArea" >
<tr>
	<td align="center">
	<form action="updatePost" name="boardPostWriteForm" method="post">
		<table id="boardControlArea2">
		<c:forEach var="p" items="${postDetail }">
			<tr>
				<td>
					<label>제목</label>
					<input id="boardUpdateTitleInput" class="boardUpdateInput" type="text" name="pb_title" value="${p.pb_title }"><br/>
					<input type="hidden" name="pb_no" value="${p.pb_no }">
				</td>
			</tr>
			<tr>
				<td>
					<label>내용</label>
					<textarea id="boardUpdateTxtInput" name="pb_content" class="boardUpdateInput">${p.pb_content }</textarea><br/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<div id="">
					<input  type="hidden" name="pb_writer" value="${p.pb_writer }"><br/>
					<button class="btnStyle1">작성</button>
					</div>
				</td>
			</tr>
				</c:forEach>
		</table>
	</form>
	</td>
	</tr>
</table>
</body>
</html>