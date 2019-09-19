<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">

</head>
<body>
	<div id="header">
		<div id="logo">
			<a href="./main.jsp">
				<img src="images/sist.jpg" width="200" border="0">
			</a>
		</div> <%-- id 로고 end --%>
		<div id="top_login">
			<ul>
				<li><a href="./main.jsp">홈</a></li>
				<li><a href="<%=request.getContextPath() %>/login.do">${name }님 </a>
				<a href="<%=request.getContextPath() %>/join.do">회원가입</a>
				<a href="<%=request.getContextPath() %>/logout.do">로그아웃</a>
			</ul>
		</div> <%--id="top_login" end --%>
	</div> <%-- id 헤더 end --%>
</body>
</html>