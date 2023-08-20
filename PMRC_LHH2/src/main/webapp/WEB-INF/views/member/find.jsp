<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript">
	
</script>
<title>PMRC</title>
<link rel="stylesheet" type="text/css" href="resources/css/find.css">
</head>

<body>
	<div class="findOuterBox">
		<div class="findInnerBox">
			<div id="findIdForm">아이디 찾기</div>
			<div>
				<form action="member.findid.do">
					<div>
						이름 : <input type="text" name="p_name">
					</div>
					<div id="findIdBtnBox1">
						<button class="w-btn-outline w-btn-gray-outline">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
