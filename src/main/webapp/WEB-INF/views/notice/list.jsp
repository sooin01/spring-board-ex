<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Notice</title>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>

<div class="container">

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
		<li class="nav-item"><a class="nav-link active" href="/notice/form">Write</a></li>
	</ul>
	
</div>

<div class="remodal" data-remodal-id="modal" data-remodal-options="hashTracking: false">
	<button data-remodal-action="close" class="remodal-close"></button>
	<h3>알림</h3>
	<p>저장하시겠습니까?</p>
	<br>
	<button data-remodal-action="confirm" class="remodal-confirm">OK</button>
	<button data-remodal-action="cancel" class="remodal-cancel">Cancel</button>
</div>

<a data-remodal-target="modal" href="#">저장</a>
	
<script type="text/javascript">
	$(document).on('confirmation', '.remodal', function() {
		alert("OK");
	});
</script>

</body>
</html>
