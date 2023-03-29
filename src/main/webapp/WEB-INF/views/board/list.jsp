<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<h1>List</h1>
<form method="get">
<select name="option">
<option value="title">title</option>
<option value="writer">writer</option>
</select>
<input type="text" name="searchWord">
<button type="submit">Search</button>
</form>
<table border="1">
	<thead>
	<tr>
	<th>seq</th><th>title</th><th>writer</th><th>cnt</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${data}" var="row">
	<tr>
	<td>${row.seq}</td>
	<td><a href="detail?seq=${row.seq}">${row.title}</a></td>
	<td>${row.writer}</td>
	<td>${row.cnt}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<p><a href="create">Create</a></p>
</body>
</html>