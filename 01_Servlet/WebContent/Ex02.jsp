<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석입니다. -->
	<%-- JSP 주석입니다. --%>
	<form method="get" action="profile">
		<p> 이 름 : <input type="text" name="name"> </p>
		<p> 나 이 : <input type="text" name="age"> </p>
		<input type="submit" value="전송">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소">
	</form>
</body>
</html>