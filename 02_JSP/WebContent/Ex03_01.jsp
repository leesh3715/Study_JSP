<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터 받기 전에 한글 처리
	request.setCharacterEncoding("UTF-8");
	// 파라미터 값을 받아보자
	String id = request.getParameter("id").trim();
	String pwd = request.getParameter("pwd").trim();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
	ID : <%=id%> <br>
	PWD: <%=pwd%>
	</h2>

</body>
</html>