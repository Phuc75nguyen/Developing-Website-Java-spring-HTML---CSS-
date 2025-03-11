<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>IndexRecord</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	line-height: 25px;
	border: 1px solid black;
	padding: 5px;
}

th {
	background-color: gray;
}
</style>
</head>
<body>
	${message}
	<table class="table table-hover">
		<tr>
			<th>Mã ghi nhận</th>
			<th>Type</th>
			<th>Reason</th>
			<th>Date</th>
			<td><a href="insert.htm">Insert</a></td>
		</tr>
		<c:forEach var="r" items="${records}">
			<tr>
				<td>${r.id}</td>
				<td>${r.type?'Thành tích':'Kỷ luật'}</td>
				<td>${r.reason}</td>
				<td>${r.date}</td>
				<td><a href="update.htm">Edit</a> |
					<form action="index/${r.id}.htm" method="post"
						style="display: inline;">
						<input type="submit" value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>