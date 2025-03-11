<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>InsertRecord</title>
</head>
<body>
	${message}
	<form:form class="insert.htm" modelAttribute="record">
		<div>
			<label>Nhân Viên</label>
			<form:select path="staffs.id" items="${staffs}" itemValue="id"
				itemLabel="name" />
		</div>
		<div>
			<label>Loại</label>
			<form:radiobutton path="type" value="true" label="Thành tích" />
			<form:radiobutton path="type" value="false" label="Kỷ luật" />
		</div>
		<div>
			<label>Lý do</label>
			<form:textarea path="reason" row="3" />
		</div>
		<div>
			<button>Insert</button>
		</div>
	</form:form>
</body>
</html>