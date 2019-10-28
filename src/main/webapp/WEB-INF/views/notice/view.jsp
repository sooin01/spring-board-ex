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

	<form id="inputForm">
		<div class="form-group">
			<label for="title">Title</label>
			${board.title}
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			${board.content}
		</div>
	</form>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" id="list">list</a></li>
	</ul>

</div>
	
<script type="text/javascript">
	$('#list').on('click', function(e) {
		e.preventDefault();
		
		location.href = '/notice/list';
	});
</script>

</body>
</html>
