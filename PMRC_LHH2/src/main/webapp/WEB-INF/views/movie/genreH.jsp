<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/rank.css">
<title>Insert title here</title>
<script type="text/javascript">
	function getMovie(){
		$.ajax({
			url : "movie.get",
			success : function(movieData){
				$("#table2").empty();
				$(movieData).find("movie").each(function(i, m){
					var n = $(m).find("pm_name").text();
					var pm_code = $(m).find("pm_code").text();
					
					
					var p = $(m).find("pm_acc").text();
					var splitp = p.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
					var pNum = splitp + "명";
					var o = $(m).find("pm_genre").text();
					var nTd = $("<td></td>").text(n);
					var pTd = $("<td></td>").text(pNum);
					var oTd = $("<td></td>").text(o);
					var tr = $("<tr></tr>").append(nTd, pTd, oTd);
					$("#table2").append(tr);
				});
			}
		});
	}
	
	$(function(){
		getMovie();
		$("button").click(function(e){
				var s = $(this).val();
				$.ajax({
					url : "movie.search2",
					data : { pm_genre : s },
					success : function (movieData) {
						$("#table2").empty();
						$(movieData).find("movie").each(function(i, m){
							var n = $(m).find("pm_name").text();
							var p = $(m).find("pm_acc").text();
							var splitp = p.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
							var pNum = splitp + "명";
							var o = $(m).find("pm_genre").text();
							var nTd = $("<td></td>").text(n);
							var pTd = $("<td></td>").text(pNum);
							var oTd = $("<td></td>").text(o);
							var tr = $("<tr></tr>").append(nTd, pTd, oTd);
							$("#table2").append(tr);
						});
					}
				});
		});
		
	});
</script>
</head>
<body>
<table id="table1">
<tr><td align="center"><div id="subtitle">영화 장르별 추천 TOP 10</div></td></tr>
<tr><td align="center">
<button class="custom-btn btn-1" id="s" value="판타지">판타지</button>
<button class="custom-btn btn-1" id="s" value="범죄">범죄</button>
<button class="custom-btn btn-1" id="s" value="기타">기타</button>
<button class="custom-btn btn-1" id="s" value="가족">가족</button>
<button class="custom-btn btn-1" id="s" value="미스터리">미스터리</button>
<button class="custom-btn btn-1" id="s" value="전쟁">전쟁</button>
<button class="custom-btn btn-1" id="s" value="코미디">코미디</button>
<button class="custom-btn btn-1" id="s" value="애니메이션">애니메이션</button>
<button class="custom-btn btn-1" id="s" value="서부극(웨스턴)">서부극</button>
<button class="custom-btn btn-1" id="s" value="뮤지컬">뮤지컬</button><br>
<button class="custom-btn btn-1" id="s" value="다큐멘터리">다큐멘터리</button>
<button class="custom-btn btn-1" id="s" value="스릴러">스릴러</button>
<button class="custom-btn btn-1" id="s" value="어드벤처">어드벤처</button>
<button class="custom-btn btn-1" id="s" value="공연">공연</button>
<button class="custom-btn btn-1" id="s" value="드라마">드라마</button>
<button class="custom-btn btn-1" id="s" value="멜로/로맨스">멜로/로맨스</button>
<button class="custom-btn btn-1" id="s" value="사극">사극</button>
<button class="custom-btn btn-1" id="s" value="액션">액션</button>
<button class="custom-btn btn-1" id="s" value="SF">SF</button>
<button class="custom-btn btn-1" id="s" value="공포(호러)">공포(호러)</button><br>
</td></tr>
<tr></tr><tr></tr><tr></tr>
</table>



<div class="tbl-header">
    <table id="table3" cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th id="th1">&nbsp;Title&nbsp;</th>
          <th id="th2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Attendance</th>
          <th id="th3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Genre</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table id="table2" cellpadding="0" cellspacing="0" border="0">
      <tbody>
      </tbody>
    </table>
  </div>
  
</body>
</html>