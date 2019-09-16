<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	EL(Expression Language)
	- 표현 언어.
	- JSP 2.0 이후 버전부터 사용이 가능함
	- 라이브러리 없이 사용이 가능	
 --%>
	<h2>JSP 표현식 산술 연산 사용 예제</h2>
	<h3>
		15+7 = <%=15+7%> <br>
		15-7 = <%=15-7%> <br>
		15*7 = <%=15*7%> <br>
		15/7 = <%=15/7%> <br>
		15%7 = <%=15%7%> <br>
	</h3>
	<hr>
	<h2>표현언어(EL)에서 제공하는 산술 연산</h2>
	<h3>
		15+7 = ${15+7 } <br>	
		15-7 = ${15-7 } <br>
		15*7 = ${15*7 } <br>
		<%-- 나누기는 주의해야 함,
		우선 피 연산자를 double형으로 변환한 뒤 연산을 수행 --%>
		15/7 = ${15/7 } <br>
		15%7 = ${15%7 } <br>
	</h3>
	<hr>
	<h2>JSP 표현식에서 논리 연산 사용 예제</h2>
	<h3>
		15 == 7 : <%=15==7 %><br>
		15 != 7 : <%=15!=7 %><br>
	</h3>	
	<h2>표현언어(EL)에서 제공하는 논리 연산 </h2>
		<h3>
		15 == 7 : ${15==7}<br>
		15 != 7 : ${15!=7}<br>
		
		</h3>
	
</body>
</html>