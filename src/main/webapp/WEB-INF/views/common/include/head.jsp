<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/resources/lib/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
<link href="/resources/lib/jquery-ui/jquery-ui.min.css" rel="stylesheet">
<link href="/resources/lib/summernote/summernote-bs4.css" rel="stylesheet">
<link href="/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/lib/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="/resources/lib/bootstrap/css/bootstrap-reboot.min.css" rel="stylesheet">

<script src="/resources/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
<script src="/resources/lib/jquery-ui/jquery-ui.min.js"></script>
<script src="/resources/lib/summernote/summernote-bs4.min.js"></script>
<script src="/resources/lib/popper.js/dist/umd/popper.min.js"></script>
<script src="/resources/lib/tooltip.js/dist/umd/tooltip.min.js"></script>
<script src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ajaxStart(function() {
		$(".loader").show();
	}).ajaxStop(function() {
		$(".loader").hide();
	}).ajaxError(function(event, jqXHR) {
		alert(jqXHR.status);
	});
</script>