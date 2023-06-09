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
<form method="get">
<select name="option">
<option value="title">title</option>
<option value="category">category</option>
<option value="price">price</option>
</select>
<input type="text" name="searchWord">
<button type="submit">Search</button>
</form>
<table border="1">
	<thead>
	<tr>
	<th>title</th><th>category</th><th>price</th><th>quantity</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${data}" var="row">
	<tr>
	<td><a href="detail?book_id=${row.book_id}">${row.title}</a></td>
	<td>${row.category}</td>
	<td>${row.price}</td>
	<td>${row.quantity}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<p><a href="create">Create</a></p>
</body>
</html>