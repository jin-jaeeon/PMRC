<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript" src="resources/js/pageMoveControll.js"></script>
<script type="text/javascript">

</script>
<link rel="stylesheet" type="text/css" href="resources/css/find.css">
	<title>PMRC</title>
</head>
<body>
	<div class="findOuterBox">
		<div>
			ID : ${ID }
		</div>
		<div id="findIdBtnBox2">
			<button onclick="closePopup();" class="w-btn-outline w-btn-gray-outline">확인</button>
		</div>
	</div>
</body>
</html>
