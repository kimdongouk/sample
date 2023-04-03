<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book/list.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script type="text/javascript">

const bookSearch = function() {
	const searchSelect = $('#searchSelect').val();
	const searchText = $('#searchText').val();
	const param = {searchSelect, searchText};
	$.ajax({
		type:'GET',
		url:'/bookapi/getList',
		data: param,
		dataType:'json',
		success: function(response){
			let data = '';
			for(row of response) {
				const book_id = row['book_id'];
				data += "<tr>";
				data += "<td>"+row['title']+"</td>";
				data += "<td>"+row['category']+"</td>";
				data += "<td>"+row['price']+"</td>";
				data += '<td><button type="button" onclick="bookDelete('+book_id+')">delete</button>'; 
				data += "</tr>\n";
			}
			$('#tbody').html(data);
		}
	});
};

const bookDelete = function(book_id){
	const param = {book_id};
	$.ajax({
		type:'GET',
		url:'/bookapi/delete',
		data: param,
		dataType:'text',
		success: function(response){
			console.log('response='+response);
			bookSearch();
		}
	});
};

$(function() {
	bookSearch();
})

</script>
</head>
<body>
<h1>List</h1>
<form method="get">
<select name="option" id="searchSelect">
<option value="title">title</option>
<option value="category">category</option>
<option value="price">price</option>
</select>
<input type="text" name="searchWord" id="searchText">
<button type="button" onclick="bookSearch()">11</button>
<button type="button" value="2222">2222</button>
<button type="submit">Search</button>
</form>
<table border="1">
<thead>
<tr>
<th>title</th><th>category</th><th>price</th><th>delete</th>
</tr>
</thead>
<tbody id="tbody">
</tbody>
</table>
<p><a href="create">Create</a></p>
</body>
</html>