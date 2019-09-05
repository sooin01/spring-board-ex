<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Notice</title>
<link href="/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">First</th>
					<th scope="col">Last</th>
					<th scope="col">Handle</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>
			</tbody>
		</table>

		<c:if test="${not empty paging}">
			<nav>
				<ul class="pagination justify-content-center">
					<c:if test="${paging.prevPage > 0}">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					</c:if>
					<c:forEach var="item" begin="${paging.startPage}" end="${paging.endPage}">
						<c:choose>
							<c:when test="">
								<li class="page-item active"><a class="page-link" href="#">#{item}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="#">#{item}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.nextPage > paging.endPage}">
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</c:if>
				</ul>
			</nav>
		</c:if>

		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link active" href="/notice/form">Write</a></li>
		</ul>

	</div>
</body>
</html>
