<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="aSNSPost" id="aSNSPost">
	<c:forEach var="p" items="${postDetail }">
		<tr>
			<td align="center">
				<div id="postDetailFirstLine">
					<img src="resources/img/${p.p_photo }" class="profileImg">
					<span id="postDetailFirstLineWriter">
						작성자 : ${p.pb_writer }
					</span>
				</div>
			</td>
			<td align="right">
				<span id="postDetailFirstLineDate">
					<fmt:formatDate value="${p.pb_date }" type="date" dateStyle="Long"/>
				</span>
			</td>
		</tr>	
		<tr id="postDetailLineTr">
			<td colspan="2">
				<span id="PostDetailPostWriter">제목</span> : ${p.pb_title }
			</td>
		</tr>
		<tr id="postDetailContentTr">
			<td id="postDetailPostContent" colspan="2">
				<span id="postDetailContentSpan">
					${p.pb_content }
				</span>
			</td>
		</tr>
		<tr id="postDetailReplyTr">
			<td align="left" class="replyTd" colspan="10">
			<div id="postDetailReplyDiv">
				<c:forEach var="r" items="${postReply }">
				<div id="replyOuterBox1">
					<div id="PDR1">
						<div id="replyWriter">
							${r.psr_writer}
						</div>
						<div id="replyTxt">
							${r.psr_txt }
						</div>
					</div>
					<div id="PDR2">
						<fmt:formatDate value="${r.psr_date }" type="date" pattern = "yyyy-MM-dd HH:mm:ss"/>
					</div>
				</div>
				</c:forEach>
			</div>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="go.post/write" onsubmit="return snsReplyWriteCheck(this);" method="post">
					<span class="replyWriter">${sessionScope.loginMember.p_user }</span>
					<input name="token" value="${token }" type="hidden">				
					<input name="psr_ps_no" value="${p.pb_no }" type="hidden">		
					<input type="hidden" name="pb_no" value="${p.pb_no }">		
					<input name="psr_writer" value="${sessionScope.loginMember.p_user}" type="hidden">				
					<input name="psr_txt" maxlength="120" class="replyTxt">				
					<input name="psr_file" value="${sessionScope.loginMember.p_photo}" type="hidden">				
				<button>댓글 쓰기</button>
				</form>
			</td>
			</tr>
			<tr>
				<td align="right">
					<button onclick="goList();">목록</button>	
					<c:if test="${sessionScope.loginMember.p_user == p.p_user or sessionScope.loginMember.p_user == p.pb_writer  }">
						<button onclick="gopostUpdate(${p.pb_no});">수정</button>	
						<button onclick="deletePost(${p.pb_no});">삭제</button>
					</c:if>
				</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>