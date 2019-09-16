<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

	/* String id = request.getParameter("id").trim();
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String pwd = request.getParameter("pwd"); */


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h2>JSP 표현식으로 파라미터 값을 출력하는 방법</h2>
	<table border="1" width="300" cellspacing="0">
		<tr>
			<th>아이디</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=age %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=pwd %></td>
		</tr>
	</table> --%>
	
	<h2>표현 언어(EL)로 파라미터 값을 출력하는 방법</h2>
	<table border="1" width="300" cellspacing="0">
		<tr>
			<th>아이디</th>
			<td>${param.id }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${param.name }</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${param.age }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${param.pwd }</td>
		</tr>
	</table>
</body>
</html>