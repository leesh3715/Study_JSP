<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL 태그 라이브러리 사용하기 위해 지시자 설정 --%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="skyblue">
		<h3>MVC2 모델 방식의 BOARD 테이블 메인 페이지</h3>
		<hr width="50%" color="skyblue">
		<a href="<%=request.getContextPath()%>/select.do">[전체 목록]</a> <!-- .do로 매핑되면 frontcontroller로 감 -->
	</div>
	
</body>
</html>