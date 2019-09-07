<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
	$(document).ajaxStart(function() {
		$(".loader").show();
	}).ajaxStop(function() {
		$(".loader").hide();
	}).ajaxError(function(event, jqXHR) {
		alert(jqXHR.status);
	});
</script>