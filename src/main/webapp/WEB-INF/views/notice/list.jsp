<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Notice</title>
<%@ include file="/WEB-INF/views/common/include/head.jsp" %>
</head>
<body>

<div class="container">

	<header class="blog-header py-3">
		<div class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-12 text-center" id="clock"></div>
		</div>
	</header>

	<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">등록아이디</th>
				<th scope="col">등록날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${noticeList}">
				<tr>
					<th scope="row">${item.seq}</th>
					<td>${item.title}</td>
					<td>${item.userId}</td>
					<td>${item.createDt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<nav>
		<ul class="pagination justify-content-center">
			<c:if test="${paging.prevPage > 0}">
				<li class="page-item"><a class="page-link" href="#" onclick="return false;">Previous</a></li>
			</c:if>
			<c:forEach var="item" begin="${paging.startPage}" end="${paging.endPage}">
				<c:choose>
					<c:when test="${item eq paging.page}">
						<li class="page-item active"><a class="page-link" href="#" onclick="return false;">${item}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="#" onclick="return false;">${item}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.nextPage > paging.endPage}">
				<li class="page-item"><a class="page-link" href="#" onclick="return false;">Next</a></li>
			</c:if>
		</ul>
	</nav>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" onclick="goWrite(); return false;">Write</a></li>
		<li class="nav-item"><a class="nav-link active" href="#" onclick="goWrite2(); return false;">Write2</a></li>
	</ul>
	
</div>

<div id="dialog-confirm" title="알림" style="display:none;">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>작성페이지로 이동하시겠습니까?</p>
</div>

<style type="text/css">
.fixed-dialog { position: fixed; }
.ui-widget-overlay { background: #aaaaaa; opacity: .5; filter: Alpha(Opacity=.3); /* support: IE8 */ }
</style>

<script type="text/javascript">
	function goWrite() {
		$.confirm({
			title : '알림!',
			content : '작성페이지로 이동하시겠습니까?',
			buttons : {
				확인 : function() {
					location.href = '/notice/form';
				},
				취소 : function() {
				}
			}
		});
	}

	function goWrite2() {
		$("#dialog-confirm").dialog({
			resizable : false,
			height : "auto",
			width : 350,
			modal : true,
			draggable : false,
			dialogClass : 'fixed-dialog',
			clickOutside : true,
			open : function(event, ui) {
				$(".ui-widget-overlay").click(function() {
					$(ui).dialog("close");
				});
			},
			buttons : {
				확인 : function() {
					location.href = '/notice/form';
				},
				취소 : function() {
					$(this).dialog("close");
				}
			}
		});
	}
	
	$(document).ready(function() {
		fnDatetime();
		window.setInterval(fnDatetime, 1000);
	});
	
	var date = new Date(Number("${milliseconds}"));
	
	function fnDatetime() {
		date.setSeconds(date.getSeconds() + 1);
		
		var datetime = [];
		datetime.push(date.getFullYear());
		datetime.push("년 ");
		datetime.push(date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1);
		datetime.push("월 ");
		datetime.push(date.getDate() < 10 ? "0" + date.getDate() : date.getDate());
		datetime.push("일 ");
		datetime.push(date.getHours() < 10 ? "0" + date.getHours() : date.getHours());
		datetime.push("시 ");
		datetime.push(date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes());
		datetime.push("분 ");
		datetime.push(date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds());
		datetime.push("초");
		
		$("#clock").html(datetime.join(""));
	}
</script>

</body>
</html>
