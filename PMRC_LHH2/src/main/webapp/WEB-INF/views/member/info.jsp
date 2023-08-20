<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="infoBox">
		<table id="memberInfoTbl">
	<form name="memberUpdateForm" onsubmit="return memberUpdateCheck();" action="member.info.update" method="post" enctype="multipart/form-data">
			<tr>
				<th class="infoTxt" >ID : ${sessionScope.loginMember.p_user }</th>
			</tr>
			<tr>	
				<th class="infoTxt" >이름 : ${sessionScope.loginMember.p_name }</th>
			</tr>
			<tr>
				<td align="center">
					<input name="p_password" class="tdInput" maxlength="10" placeholder="pw(숫자포함)" type="password" value="${sessionScope.loginMember.p_password }">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="p_pwChk" class="tdInput" maxlength="10" placeholder="pw확인" type="password"value="${sessionScope.loginMember.p_password }" ><br>
				<br></td>
			</tr>
			<tr>
				<td class="td1" align="center">생일</td>
			</tr>
			<tr>
				<td align="center">
					<fmt:formatDate value="${sessionScope.loginMember.p_birthday }" type="date" dateStyle="long"/><br><br>
				</td>
			</tr>
			<tr>
				<td align="center">프사</td>
			</tr>
			<tr>
				<td align="center">
					<img id="memberInfoImg"src="resources/img/${sessionScope.loginMember.p_photo }"><br>
					<input type="file" name="p_photo">
					<hr>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>정보수정</button>
	</form>
					<button onclick="location.href='member.bye'">탈퇴</button>
				</td>
			</tr>
		</table>
		</div>
</body>
</html>







