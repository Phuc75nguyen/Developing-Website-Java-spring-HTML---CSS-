<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateRecord</title>
</head>
<body>
	${message}
	<form:form class="update.htm" modelAttribute="record">
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
			<button>Update</button>
		</div>
	</form:form>
</body>
</html>