<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 내장 객체
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String hobby[] = request.getParameterValues("hobby");
	String email = request.getParameter("email");
	String addr = request.getParameter("addr");
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	ID : <%=id%><br>
	PWD : <%=pwd%><br>
	NAME : <%=name%><br>
	GENDER : <%=gender%><br>
	HOBBY : 
	<%
	for(String h:hobby) {%>
		<%=h%>&nbsp;&nbsp;&nbsp;
	<% }
	%>
	 
	<br>
	email : <%=email%><br>
	ADDR : <%=addr%><br>
</body>
</html>