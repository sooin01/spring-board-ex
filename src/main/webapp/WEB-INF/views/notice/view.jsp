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
		<div class="row">
			<div class="col-4 bg-light">Title</div>
			<div class="col-8">${board.title}</div>
		</div>
		<div class="row">
			<div class="col-4 bg-light">Content</div>
			<div class="col-8">${board.content}</div>
		</div>
	</form>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" id="delete">delete</a></li>
		<li class="nav-item"><a class="nav-link active" href="#" id="form">form</a></li>
		<li class="nav-item"><a class="nav-link active" href="#" id="list">list</a></li>
	</ul>

</div>
	
<script type="text/javascript">
	$('#delete').on('click', function(e) {
		e.preventDefault();
		
		$.confirm({
			title : '알림!',
			content : '삭제하시겠습니까?',
			buttons : {
				확인 : function() {
					location.href = '/notice/delete?seq=${param.seq}';
				},
				취소 : function() {
				}
			}
		});
	});
	
	$('#form').on('click', function(e) {
		e.preventDefault();
		
		location.href = '/notice/form?seq=${param.seq}';
	});

	$('#list').on('click', function(e) {
		e.preventDefault();
		
		location.href = '/notice/list';
	});
</script>

</body>
</html>
