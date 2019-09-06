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
		JSP 페이지 내장 객체
		- 내장 객체는 JSP 페이지 내에서 제공하는 특수한 레퍼런스 타입의 변수 이다.
		- JSP 페이지에서 사용하게 되는 특수한 레퍼런스 타입의 변수가 아무런 선언과 객체 생성 없이 사용할 수 있는 이유는 JSP 페이지가 Servlet으로 변환될 때
		JSP 컨테이너가 자동적으로 제공을 해 주고 있기 때문이다.
		
		JSP의 내장(내부) 객체
		- pageContext : JSP 페이지에 대한 정보를 저장하고 있는 객체
		- request : 웹 브라우저의 요청 정보를 저장하고 있는 객체
		- response : 웹 브라우저의 요청에 대한 응답 정보를 저장하고 있는 객체
		- out : JSP 페이지에 출력할 내용을 가지고 있는 출력 스트림 객체
		- session : 하나의 웹 브라우저의 정보를 유지하기 위한 세션 정보를 저장하고 있는 객체
		- application: 웹 어플리케이션 Context 의 정보를 저장하고 있는 객체
		
		내장(내부) 객체 사용 시 공통적으로 사용하는 메서드
		- setAttribute(String key, Object value) : 주어진 key 속성 값을 value로 지정한다.(리턴 void)
		- getAttribute(String key): 주어진 key 속성의 값(value)을 얻어낸다.(리턴타입: Object)
		- removeAttribute(String key): 주어진 key 속성의 값(value)을 제거 한다.(리턴 void)
		- getAttributeNames(): 모든 속성의 이름을 구한다.
	 --%>
	 <%--
	 
	 	JSP 페이지 이동: forward, redirect
	 	
	 	1. forward
	 		- request 영역(scope)에 담긴 값이 유효함.
	 		(request, response 가 유지된다.)
	 		- 이동된 화면에 url 창에 안보인다.(사용자는 이동했는지 알 수 없음)
	 		- 키 값을 넘겨 줄 때 사용함.
	 		형식) RequestDispathcer rd = request.getRequesetDispathcer("이동위치");
	 			rd.forward(request, response);
	 	2. sendRedirect
	 		- 클라이언트가 새로 페이지를 요청한 것과 같은 방식으로 페이지가 이동 됨
	 		- 일반적으로 변수 값을 넘겨줄 때 사용함.
	 		- request, response가 유효하지 않음(새로 만들어짐)
	 		- 이동된 url이 화면에 나타남(보안에 취약)
	 		형식) response.sendRedirect("이동위치");
	 		 
	  --%>
	  
	  <form method="post" action="Ex06.jsp">
	  	<p> 아이디  <input type="text" name="id"> </p>
	  	<p> 비밀번호  <input type="password" name="pwd"> </p>
	  	<input type="submit" value="로그인">
	  </form>
</body>
</html>