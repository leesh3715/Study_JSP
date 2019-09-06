<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("nai"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신의 나이는 <%=age %>이며,<br>
		20세 이상 관람 등급 가능 영화관에 오셨습니다~~</h3>
</body>
</html>