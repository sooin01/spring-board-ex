<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/common/include/taglibs.jsp" %>
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
		</div>
	</header>

	<div class="row">
		<div class="col-10">
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
		</div>
	</div>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" onclick="goWrite(); return false;">Write</a></li>
	</ul>
	
</div>

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

	$(document).ready(function() {
	});
</script>

</body>
</html>
