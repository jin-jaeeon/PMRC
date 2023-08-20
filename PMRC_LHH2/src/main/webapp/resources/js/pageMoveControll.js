
function closePopup() {
	 window.open("find.go", "mypopup", "width=250, height=250, top=100, left=200").close();
}

function openPopUp() {
	// 함수 동작 테스트 
	//alert("팝업 테스트");
	
	//window.open("[팝업을 띄울 파일명 path]", "[별칭]", "[팝업 옵션]")
	 window.open("find.go", "mypopup", "width=250, height=250, top=100, left=200");
}
//function connectMenuSummonEvent(){
//	$("#menuIcon").click(function(){
//		$("#siteTitleArea3").css("top","0px");
//	});
//	$("menuIcon").click(function(){
//		$("#siteTitleArea3").css("top","-60px");
//	});
//}

function pagingNumColor(){
	var i = $('#toChooseCurrentPage').val();
	$(".pagingNum:nth-of-type("+i+")").css({
		"color" : "olive"
	});
//	if ($('#pagingNum')===i) {
//		alert(i);
//	}
}




function postSearchCheck() {
	var searchField = document.postSearchForm.search;
	if (isEmpty(searchField)) {
		alert("검색어를 입력하시오");
		return false;
	}
	return true;
}

function gopostUpdate(no) {
	if (confirm("게시글을 수정하시겠습니까?")) {
	location.href="go.updatePost?pageDetail="+no;
 }
}

function deletePost(no) {
	if (confirm("게시글을 정말 삭제하시겠습니까?")) {
		location.href="delete.post?pb_no="+no;
	}
}

function goLoginPage(){
	location.href="goindex.go";
}

function goList() {
		location.href="go.sns";
}


$(function(){
	$(".nav li ").click(function() {

        $(this).children("ul").stop().slideToggle(500)

      })
});