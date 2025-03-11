
<%@ page language="java" contentType="text/html; charset= utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>QUẢN LÍ SINH VIÊN</h1>
	<form action="student-mgr.htm" method="post">
		${message}

		<div>Họ và tên</div>
		<input name="name" />

		<div>Điểm trung bình</div>
		<input name="mark" />

		<div>Chuyên ngành</div>
		<label> <input name="major" type="radio" value="APP" /> Ứng
			dụng phần mềm
		</label>

		<div>Chuyên ngành</div>
		<label> <input name="major" type="radio" value="WEB" /> Thiết
			kế trang Web
		</label>

		<hr>
		<button name="btnInsert">Thêm</button>
		<button name="btnUpdate">Cập nhật</button>
		<button name="btnDelete">Xóa</button>
		<button name="btnReset">Nhập lại</button>
	</form>
	<hr>
	<table border="1" style="width: 100%">
		<tr>
			<th>Họ và tên</th>
			<th>Điểm Trung bình</th>
			<th>Chuyên ngành</th>
		</tr>

		<tr>
			<td>Nguyễn Tú Huỳnh</td>
			<td>9.5</td>
			<td>CÔNG NGHỆ THÔNG TIN</td>
			<td><a href="student-mgr.htm?lnkEdit">Sửa</a></td>
		</tr>

		<tr>
			<td>Nguyễn Tấn Phúc</td>
			<td>9.0</td>
			<td>KHOA HỌC MÁY TÍNH</td>
			<td><a href="student-mgr.htm?lnkEdit">Sửa</a></td>
		</tr>
	</table>


</body>
</html>