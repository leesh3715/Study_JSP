<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="skyblue">
		<h3>MEMBER1 테이블 레코드 삭제 폼</h3>
		<hr width="50%" color="skyblue">
		<form method="post" action="<%=request.getContextPath()%>/delete.do">
			<table border="1" width="300" cellspacing="0">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="삭제">&nbsp;&nbsp;&nbsp; 
					<input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>