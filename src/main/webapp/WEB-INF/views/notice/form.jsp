<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Notice</title>
<link href="/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>
<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
<script type="text/javascript">
	$(document).ajaxStart(function() {
		$(".loader").show();
	}).ajaxStop(function() {
		$(".loader").hide();
	});
</script>
</head>
<body>

<div class="container">

	<div class="loader" style="display: none;"></div>

	<form id="inputForm">
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" id="title" placeholder="Enter title">
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<input type="text" class="form-control" id="content" placeholder="Enter content">
		</div>
	</form>

	<form id="uploadForm" method="post" enctype="multipart/form-data">
		<div class="input-group">
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="file" name="file">
				<label class="custom-file-label" for="file">Choose file</label>
			</div>
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button" id="upload">Upload</button>
			</div>
		</div>
	</form>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#" id="list">list</a></li>
		<li class="nav-item"><a class="nav-link active" href="#" id="save">save</a></li>
	</ul>

</div>
	
<script type="text/javascript">
	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});
	
	$('#upload').on('click', function(e) {
		e.preventDefault();
		
		var formData = new FormData();
		formData.append("file", $("input[name=file]")[0].files[0]);
		
		$.ajax({
            type: 'POST',
            url: '/notice/upload',
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            data: formData,
            success: function(data) {
                alert("업로드 성공!!");
            }
        });
	});
	
	$('#list').on('click', function(e) {
		e.preventDefault();
		
		$.ajax({
            type: 'GET',
            url: '/notice/list',
            dataType: 'html',
            success: function(data) {
            	
            }
        });
	});
</script>

</body>
</html>
