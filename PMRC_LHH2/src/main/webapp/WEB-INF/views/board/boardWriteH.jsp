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
	<form action="writePost" name="boardPostWriteForm" method="post">
		<table id="boardControlArea2">
			<tr>
				<td align="center">
					<label class="txt">제목</label>
				</td>
				<td align="center">
					<input autocomplete="off" type="text" name="pb_title" class="postInput postTitleInput" placeholder="제목"><br/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<label class="txt">내용</label>
				</td>
				<td align="center">
					<textarea name="pb_content" class="postInput postTxtInput" placeholder="내용"></textarea><br/>
				</td>
			</tr>
			<tr>
				<td>
			<!-- 		<label>작성자</label> -->
					<input type="hidden" name="pb_writer" value="${sessionScope.loginMember.p_user }"><br/>
				</td>
				<td colspan="2" align="center">
					<button class="btnStyle1">작성</button>
				</td>
			</tr>
		</table>
	</form>
	</td>
	</tr>
</table>

</body>
</html>