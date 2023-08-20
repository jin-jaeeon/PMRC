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
<div id="movieDetailOuterBox">
<c:forEach var="m" items="${movieDetail }">
				<div class="movieInfoDetail2">
					<div class="movieInfoPoster">
						<img alt="" src="${m.pm_url }">
					</div>
					<div class="movieInfoTxt">
						<div class="movieInfoTxtNav">
							<span>영화제목 : ${m.pm_name }</span>
						</div >
						<div class="movieInfoTxtNav">
							<span>상영일자 :</span> ${m.pm_pyear }
						</div>
						<div class="movieInfoTxtNav">
							<span >관객수 :</span>
							<fmt:formatNumber value="${m.pm_acc }" pattern="#,###" />명
						</div>
						<div class="movieInfoTxtNav">
							<span >메인감독 :</span> ${m.pm_director }
						</div>
						<div class="movieInfoTxtNav">
							<span >영화장르 :</span> 
								${m.pm_genre }
						</div>
					</div>
				</div>
			<div>
				<table id="movieDetailTbl">
				<tr id="movieReviewNav">
					<td class="movieStarNum" align="center">
						별점			
					</td>
					<td>
						ID
					</td>
					<td>
						리뷰
					</td>
					<td align="right">
						작성일
					</td>
				</tr>
					<c:forEach var="r" items="${movieReply }">
				<tr>
					<td class="movieStarNum" align="center">
						${r.pmr_grade }   
					</td>
					<td>
						${r.pmr_writer }
					</td>
					<td>
						${r.pmr_txt }
					</td>
					<td align="right">
						<fmt:formatDate value="${r.pmr_date }" pattern="yyyy-MM-dd HH:ss"/>
					</td>
				</tr>
					</c:forEach>
		
			<tr>
			<td colspan="4">
				<form action="goMovie/write" onsubmit="return movieReplyWriteCheck(this);" method="post">
					<span class="moviereplyWriter">${sessionScope.loginMember.p_user }</span>
					<select name="pmr_grade" class="replyGrade">
						<option disabled selected>별점 ⭐</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
					<input name="token" value="${token }" type="hidden">				
					<input name="pmr_pm_code" value="${m.pm_code }" type="hidden">				
					<input name="pmr_writer" value="${sessionScope.loginMember.p_user}" type="hidden">				
					<input name="pmr_txt" maxlength="120" class="replyTxt">				
				<button class="btnStyle1">댓글 쓰기</button>
				</form>
			</td>
				<td align="right">
					<c:if test="${sessionScope.loginMember.p_grade == true  }">
						<button onclick="gomovieUpdate(${m.pm_code});">수정</button>	
						<button onclick="deleteMovie(${m.pm_code});">삭제</button>
					</c:if>
				</td>
		</tr>

				</table>
			</div>
			</c:forEach>
			</div>
			
</body>
</html>