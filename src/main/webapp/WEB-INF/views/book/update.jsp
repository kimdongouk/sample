<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book/update.jsp</title>
</head>
<body>
<form method="POST">
	<table>
	<tr><td>책번호 : <input type="hidden" name="book_id" value="${data['book_id']}"/>${data.book_id}</td></tr>
	<tr><td>제목 : <input type="text" name="title" value="${data.title}"/> </td></tr>
	<tr><td>카테고리 : <input type="text" name="category" value="${data.category}"/> </td></tr>
	<tr><td>가격 : <input type="text" name="price" value="${data.price}"/> </td></tr>
	<tr><td><input type="submit" value="submit" /> </td></tr>
	</table>
</form>
</body>
</html>