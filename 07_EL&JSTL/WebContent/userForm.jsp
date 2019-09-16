<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="el_02.jsp">
		<table border="1" width="300" cellspacing="0">
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>나 이</th>
				<td><input name="age"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="전송">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>