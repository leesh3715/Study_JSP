<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Calendar cal = Calendar.getInstance();
	%>
	<h2>
		<%--JSP 표현식: 변수의 값 또는 메서드의 결과 값을 출력하는 공간 --%>
		<%=cal.get(Calendar.YEAR)%>년
		<%=cal.get(Calendar.MONTH) + 1%>월
		<%=cal.get(Calendar.DAY_OF_MONTH)%>일
	</h2>
	<hr>
	<h2>1~100 까지의 합 구하기</h2>
	<%
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	%>
	<p>1 ~ 100 까지의 합: <%=sum %></p>
	<hr>
	<%-- 함수를 선언하는 공간 --%>
	<%!
	public int plus(int a, int b){
		return a + b;
	}
	%>
	<p> 7 + 5 = <%=plus(7,5) %>
	<hr>
	
	
	
	
</body>
</html>