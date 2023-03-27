<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book/list.jsp</title>
</head>
<body>
<h1>List</h1>
<table border="1">
	<thead>
	<tr>
	<th>book_id</th><th>title</th><th>category</th><th>price</th><th>insert_date</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<td>${data['book_id']}</td>
	<td>${data.title} </td>
	<td>${data.category}</td>
	<td>${data.price}</td>
	<td>${data['insert_date']}</td>
	</tr>
	</tbody>
</table>
<a href="list">List</a>
<a href="create">Create</a>
<%-- <a href="update?book_id=${data['book_id']}&title=${data.title}&category=${data.category}&price=${data.price}">Update</a> --%>
<a href="update?book_id=${data['book_id']}">Update</a>
</body>
</html>