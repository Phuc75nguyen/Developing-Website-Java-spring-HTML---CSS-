<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
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
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<td><a href="insert.htm">Insert</a></td>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.username}</td>
				<td>${u.password}</td>
				<td>${u.fullname}</td>
				<td><a href="update.htm">Edit</a> |
					<form
						action="index/${u.username}.htm"
						method="post" style="display: inline;">
						<input type="submit" value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>