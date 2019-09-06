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
		<hr width ="50%">
		<h3 align="center">MEMBER1 메인 페이지</h3>
		<hr width ="50%" color="red">
		<br><br><br>
		<%--현재 프로젝트 명을 반환하는 메서드 --%>
		<a href="<%=request.getContextPath()%>/select.do">[레코드 검색]</a>
	</div>
	
</body>
</html>