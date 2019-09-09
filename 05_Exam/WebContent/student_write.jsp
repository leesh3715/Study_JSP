<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규 학생 등록</title>
</head>
<body>
	<div align="center">
	<hr width="500" color="pink">
		<h3>학생 신규 등록</h3>
		<hr width="500" color="pink">
		<br> <br>
		<h4>학번은 자동으로 입력됩니다.</h4>
		<form method="post" action="<%=request.getContextPath()%>/insert">
		<table border="1" cellspacing="0">
		<tr><td>이 름: <input type="text" name ="name"></td></tr>
		<tr><td>아이디: <input type="text" name ="id"></td></tr>
		<tr><td>비밀번호: <input type="text" name ="pwd"></td></tr>
		<tr><td>전화번호: <input type="text" name ="tel"></td></tr>
		<tr><td>전 공: <input type="text" name ="major"></td></tr>
		<tr><td>학 년: <input type="text" name ="grade"></td></tr>
		</table>
		<br><br>
	<input type="submit" value="학생 등록">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
		</form>
	</div>
</body>
</html>