<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		JSTL(JSP Standard Tag Library)
		 - JSP 페이지에서 스크립트릿과 HTML코드가 뒤섞이게 되는 현상 발생
		이렇게 뒤섞인 코드는 알아보기가 쉽지 않게 되는 단점이 발생, 따라서 가독성이 낮아짐
		 - JSP 페이지에서 스크립트릿에 들어가는 내용들 중에	 논리적인 판단, 반복 처리, 포맷 처리 등을 HTML 태그처럼 처리할 수 있도록 표준으로 만들어서 정의 한 것이 JSTL 라이브러리
	 --%>
	 <%--
	 	기본적인 JSP 태그(출력은 EL을 사용)
	 	1. 변수 태그(set)
	 		<c: set var="변수명" value="값">
	 		예) String test = "Hello";
	 			<c:set var="test" value="Hello">
	 	2. 출력 태그(out)
	 		<c: out value="변수명">
	 		예) <c: out value="test">
	 	3. 삭제 태그(remove)
	 		<c:remove var="변수명">
	 		예) <c:remove var="test">
	 	4. 조건 처리(if문): else 문이 없음
	 		<c: if test="조건식" var="변수명">
	 	5. 조건 처리(choose문): switch~case문과 유사
	 		<c: choose>
	 			<c:when test="조건식1"> 조건식 1이 맞는 경우 실행 문장 </c: when>
	 			<c:when test="조건식2"> 조건식 2이 맞는 경우 실행 문장 </c: when>
	 			<c:when test="조건식3"> 조건식 3이 맞는 경우 실행 문장 </c: when>
	 			<c:otherwise> 상기 조선식 이외의 경우</c: when>
	 			</c:otherwise>
		6. 반복문(forEach문): for문
			<c:forEach begin="시작값" end="끝값" step="증감값" var="변수명">
			<c:forEach item="객체명" var="변수명">	 			
	  --%>
	  <h2>JSTL의 기본적인 태그들</h2>
	  <h3>
	  	<c:set var="test" value="Hello JSTL!!!"/>
	  	JSTL 값 출력: <c:out value="test"/><br>
	  	JSTL 값 출력: <c:out value="${test }"/><br>
	  	값 삭제: <c:remove var="test"/><br>
	  	삭제 후 값 출력: <c:out value="${test }"/><br>
	  	<hr>
	  	
	  	<c:if test="${10 > 5 }" var="k"></c:if>
	  	결과: <c:out value="${k }"/><br>
	  	<hr>
	  	
	  	<%-- test2의 값이 1이면 합격, 2이면 불합격 나머지는 미발표 --%>
	  	<c:set var="test2" value="1"/>
	  	<c:out value="${test2 }"/><br>
	  	<c:choose>
	  		<c:when test="${test2==1}">결과: 합격입니다.</c:when>
	  		<c:when test="${test2==2}">결과: 불합격입니다.</c:when>
	  		<c:otherwise>결과: 발표 전입니다.</c:otherwise>
	  	</c:choose>
		<hr>
		<%-- 1 ~ 10까지 출력 --%>
		<c:forEach begin="1" end="10" step="1" var="i"> 
		
			${i }&nbsp;
		</c:forEach>
		<hr>
		<%-- 배열의 값들을 출력해 보자. --%>
		<%
			String[] name = {"홍길동","이순신","유관순","김유신","김연아"};
			pageContext.setAttribute("List", name);
		%>
		결과: <c:forEach items="${List }" var="str">
				${str }&nbsp;&nbsp;&nbsp;
		</c:forEach>
		<hr>
		<%
			pageContext.setAttribute("title", "JSTL 태그 라이브러리");
		%>
		<c:if test="${!empty title }">
			${title }
		</c:if>
		<c:if test="${!empty title2 }">
			${title2 }
		</c:if>
		
	 </h3>
</body>
</html>