<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/common/include/taglibs.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Login</title>
<%@ include file="/WEB-INF/views/common/include/head.jsp" %>
</head>
<body>

<div class="container">
	
	<form method="post" action="/login">
		<div class="form-group">
			<label for="username">아이디</label>
			<input type="text" class="form-control" id="username" name="username" value="test" placeholder="Enter ID">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" id="password" name="password" value="1234" placeholder="Enter Password">
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>

</div>

</body>
</html>
