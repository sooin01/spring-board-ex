<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Board</title>
<script type="text/javascript" src="/resources/lib/vue.js/vue.js"></script>
<script type="text/javascript" src="/resources/lib/axios/axios.js"></script>
</head>
<body>

<div id="list">
	{{items}}
	<button v-on:click="fetchData">get data</button>
</div>

<script type="text/javascript">
	new Vue({
		el: '#list',
		data: {
			items: []
		},
		methods: {
			fetchData: function() {
				axios.get('http://localhost:8080/board/list')
				.then(function(response) {
					this.items = response.data;
				})
				.catch(function(error) {
					console.log(error);
				});
			}
		}
	});
</script>
</body>
</html>