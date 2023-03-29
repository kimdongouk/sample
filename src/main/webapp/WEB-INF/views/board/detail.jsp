<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/detail.jsp</title>
</head>
<body>
<h1>Detail</h1>
<table border="1">
	<thead>
	<tr>
	<th>seq</th><th>title</th><th>writer</th><th>content</th><th>regdate</th><th>cnt</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<td>${data.seq}</td>
	<td>${data.title} </td>
	<td>${data.writer}</td>
	<td>${data.content}</td>
	<td>${data.regdate}</td>
	<td>${data.cnt}</td>
	</tr>
	</tbody>
</table>
<a href="list">List</a>
<a href="create">Create</a>
<%-- <a href="update?book_id=${data['book_id']}&title=${data.title}&category=${data.category}&price=${data.price}">Update</a> --%>
<a href="update?seq=${data.seq}">Update</a>
<a href="delete?seq=${data.seq}">Delete</a> 
</body>
</html>