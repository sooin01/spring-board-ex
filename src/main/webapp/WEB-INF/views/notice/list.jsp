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

	<%@ include file="/WEB-INF/views/common/include/common.jsp" %>

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
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			</c:if>
			<c:forEach var="item" begin="${paging.startPage}" end="${paging.endPage}">
				<c:choose>
					<c:when test="${item eq paging.page}">
						<li class="page-item active"><a class="page-link" href="#">${item}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="#">${item}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.nextPage > paging.endPage}">
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
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
					//location.href = '/notice/form';
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
					//location.href = '/notice/form';
				},
				취소 : function() {
					$(this).dialog("close");
				}
			}
		});
	}
</script>

</body>
</html>
