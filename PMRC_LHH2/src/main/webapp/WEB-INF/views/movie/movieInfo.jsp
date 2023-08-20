<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		var genre = $("#b1");

		$("#b2").click(function() {
			alert(genre.val());
		});
	});
</script>
</head>
<body>

<div id="movieInfoImgBox">
	<div id="movieInfoImgBox2">
		<div class="innerMovieInfoBox">
			<c:forEach var="m" items="${Movies }" begin="0" end="2">
				<div class="movieInfoDetail">
					<div class="movieInfoPoster">
						<img alt="" src="${m.pm_url }">
					</div>
					<div class="movieInfoTxt">
						<div class="movieInfoTxt2">
							<span class="movieInfoTxtNav">영화제목 :</span> <a id="pm_code" href="/sproject/goMovie?pageDetail=${m.pm_code }">${m.pm_name }</a>
						</div>
						<div class="movieInfoTxt2">
							<span class="movieInfoTxtNav">상영일자 :</span> ${m.pm_pyear }
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="innerMovieInfoBox">
			<c:forEach var="m" items="${Movies }" begin="3" end="5">
				<div class="movieInfoDetail">
					<div class="movieInfoPoster">
						<img alt="" src="${m.pm_url }">
					</div>
					<div class="movieInfoTxt">
						<div class="movieInfoTxt2">
							<span class="movieInfoTxtNav">영화제목 :</span> <a id="pm_code" href="/sproject/goMovie?pageDetail=${m.pm_code }">${m.pm_name }</a>
						</div>
						<div class="movieInfoTxt2">
							<span class="movieInfoTxtNav">상영일자 :</span> ${m.pm_pyear }
						</div>
						
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="movieInfoOuterBox">
		<c:if test="${page != 1 }">
			<div class="moviePageMoveBtn">
				<a href="movie.searchP?page=${page-1 }" class="moviePagingBtn">&lt</a>
			</div>
		</c:if>
		<div id="movieCurrentPageNum">${page }</div>
		<c:if test="${page != pageCount }">
			<div class="moviePageMoveBtn">
				<a href="movie.searchP?page=${page+1 }" class="moviePagingBtn">&gt</a>
			</div>
		</c:if>
	</div>



	<div id="movieSearchBox">
		<form action="movie.search">
			<input name="search" placeholder="제목 검색">
			<button>검색</button>
		</form>
	<div id="movieCountBox">
	전체 Data 갯수 : <fmt:formatNumber value="${MovieCount }" pattern="#,###" /><br>
	검색 결과 : <fmt:formatNumber value="${searchCount }" pattern="#,###" />
	</div>	
		
	</div>
	<input id="b1" value="${Movie.pm_genre }" type="hidden">
	<input id="b2" type="hidden">
</div>
</body>
</html>