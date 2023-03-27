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
<tr><td>책번호 : ${data.book_id}</td></tr>
<tr><td>제목 : <input type="text" name="title" /> </td></tr>
<tr><td>카테고리 : <input type="text" name="category" /> </td></tr>
<tr><td>가격 : <input type="text" name="price" /> </td></tr>
<tr><td><input type="submit" value="submit" /> </td></tr>
</table>
</form>
</body>
</html>