<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet 등록 방법(2가지)</title>
</head>
<body>

	<h2>두 수 더하기(애노테이션(1:1) 등록)</h2>
	<form method="get" action="adder1">
		<p> 첫번 째 수 : <input type="text" name="num1"> </p>
		<p> 두번 째 수 : <input type="text" name="num2"> </p>
	    <input type="submit" value="더하기">
	</form>
	<hr>
	
	
	<h2>두 수 더하기(배포서술자 - web.xml 등록)</h2>
	<form method="get" action="adder2">
		<p> 첫번 째 수 : <input type="text" name="num1"> </p>
		<p> 두번 째 수 : <input type="text" name="num2"> </p>
	    <input type="submit" value="더하기">
	</form>
	
	<%--
		서블릿 등록 방법 2가지
		1. 에노테이션 등록
			- Servlet의 url-mapping에 등록
			- 1:1 방식으로 등록
			- 설정파일 없이 등록이 용이
		2. 배포서술자 등록
			- web.xml 파일에 등록
			- 등록할 서블릿이 많은 경우에 일괄처리 용이
			*서블릿 등록 목적: 처리 프로그램을 url에서 숨긴다, 파일, 폴더명 숨긴다. 보안을 목적으로 한다.
							
	 --%>
	
</body>
</html>