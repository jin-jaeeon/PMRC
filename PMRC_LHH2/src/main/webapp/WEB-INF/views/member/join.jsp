<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>PMRC</title>
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<script type="text/javascript" src="resources/js/kwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/bpbascpCheck.js"></script>
</head>
<body>

	<div id="joinFormOuterBox">
		<form name="joinForm" onsubmit="return joinCheck();"
			action="member.join.do" method="post" enctype="multipart/form-data">
			<table id="joinTbl">
				<tr>
					<th colspan="2">회원가입</th>
				</tr>
				<tr>
					<td class="td1" align="right">ID</td>
					<td align="center"><input id="joinID" name="p_user"
						maxlength="10" autocomplete="off" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td class="td1" align="right">PW</td>
					<td align="center"><input name="p_password" maxlength="10"
						type="password"></td>
				</tr>
				<tr>
					<td class="td1" align="right">PW확인</td>
					<td align="center"><input name="p_chk" maxlength="10"
						type="password"></td>
				</tr>
				<tr>
					<td class="td1" align="right">이름</td>
					<td align="center"><input name="p_name" maxlength="10"
						autocomplete="off"></td>
				</tr>
				<tr>
					<td class="td1" align="right">생일</td>
					<td align="center"><select name="p_y">
							<c:forEach var="y" begin="${curYear - 100 }" end="${curYear }">
								<option>${y }</option>
							</c:forEach>
					</select> 년&nbsp;&nbsp; <select name="p_m">
							<c:forEach var="m" begin="1" end="12">
								<option>${m }</option>
							</c:forEach>
					</select> 월&nbsp;&nbsp; <select name="p_d">
							<c:forEach var="d" begin="1" end="31">
								<option>${d }</option>
							</c:forEach>
					</select> 일</td>
				</tr>

				<tr>
					<td class="td1" align="right">프사</td>
					<td align="center"><input type="file" name="p_photo"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button>가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
