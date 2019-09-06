<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex03_01.jsp"> <%-- .jsp 확장자를 붙이지 않으면 서블릿으로 넘어감 --%>
		<p>아이디: <input type="text" name="id"></p>
		<p>비밀번호: <input type="password" name="pwd"></p>
		<input type="submit" value="jsp로 전송">
	
	</form>
</body>
</html>