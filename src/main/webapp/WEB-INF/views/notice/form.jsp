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
		<input type="hidden" name="seq" value="${param.seq}">
	
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" id="title" name="title" value="${board.title}" placeholder="Enter title">
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control" id="content" name="content">${board.content}</textarea>
		</div>
		<div class="form-group">
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="file" name="file">
				<label class="custom-file-label" for="file">Choose file</label>
			</div>
		</div>
		<div class="form-group">
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" name="categorys" value="normal" id="normal">
				<label class="form-check-label" for="normal">Normal</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" name="categorys" value="etc" id="etc">
				<label class="form-check-label" for="etc">ETC</label>
			</div>
		</div>
	</form>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" id="list">list</a></li>
		<li class="nav-item"><a class="nav-link active" href="#" id="save">save</a></li>
	</ul>

</div>
	
<script type="text/javascript">
	$(document).ready(function() {
		$('#content').summernote({
			placeholder: '내용을 입력하세요.',
			height: 300
		});
	});
	
	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});
	
	$('#save').on('click', function(e) {
		e.preventDefault();
		
		var formData = new FormData($("#inputForm")[0]);
		
		$.ajax({
            type: 'POST',
            url: '/notice/save',
            processData: false,
            contentType: false,
            data: formData,
            success: function(data) {
            	location.replace("/notice/view?seq=" + data);
            }
        });
	});
	
	$('#list').on('click', function(e) {
		e.preventDefault();
		
		location.replace('/notice/list');
	});
</script>

</body>
</html>
