<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/update.jsp</title>
</head>
<body>
<form method="POST">
	<table>
	<tr><td>글번호 : <input type="hidden" name="seq" value="${data.seq}"/>${data.seq}</td></tr>
	<tr><td>작성자 : ${data.writer} </td></tr>
	<tr><td>제목 : <input type="text" name="title" value="${data.title}"/> </td></tr>
	<tr><td>내용 : <input type="text" name="content" value="${data.content}"/> </td></tr>
	<tr><td><input type="submit" value="submit" /> </td></tr>
	</table>
</form>
</body>
</html>