<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int res = (Integer) request.getAttribute("Result"); // 정수형 형변환
	if (res > 0) {
		out.println("레코드 추가 성공");
	} else {
		out.println("레코드 추가 실패");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/select.do">[테이블 보기]</a>
</body>
</html>