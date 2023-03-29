<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$.ajax({
	type : 'GET',
	url : '/bookapi/detail',
	data : { "book_id" : 26 },
	dataType : 'JSON',
	success: function(response) {
		console.log(response);
	}
});
</script>
</head>
<body>

</body>
</html>