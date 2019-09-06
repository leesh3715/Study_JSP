<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석입니다. : 소스 보기에서 볼 수 있다. -->
	<%-- JSP 주석 입니다. : 소스 보기에서 볼 수 없다. --%>
	
	<%--
		JSP: 스크립트 요소
		1. <% %>: 스크립트릿, 이 태그 안에는 자바 코드를 작성 하고 실행할 때 사용
		2. <%= %>: JSP 표현식, 변수, 메서드의 결과 값을 가져올 때, 즉 값을 출력할 때 사용하는 공간
		3. <%! %>: JSP 선언부 = 메서드를 선언 할 때 사용
		
		디렉티브: 지시어 ==> JSP 페이지에 대한 설정 정보를 지정
		1. <%@ page %>: JSP 페이지에 대한 정보를 지정.
		 - 어떻게 처리해야 하는지, 전달하기 위한 내용도 담고 있는 공간
		 - 클라이언트의 요청에 JSP 페이지가 실행이 될 때 필요한 정보를 JSP컨테이너에게 알리는 역할을 한다.
		2. <%@ taglib %>: 사용할 태그 라이브러리 지정(예: JSTL언어 사용 시)
		3. <%@ include %>: 현재 문서에서 다른 문서를 가져와서 컴파일 할 때
			<%@ include file="포함할 파일의 URL" %>
			include 지시어를 사용한 JSP 페이지가 컴파일이 되는 과정에서 
			include 되는 JSP 페이지 소스의 내용을 그대로 포함해서 컴파일을 함
			- 복사&붙여넣기 방식으로 두 개의 파일이 하나의 파일로 구성이 된 후 같이 컴파일 된다.
		
		1. 페이지 지시어
		<%@ page language="java" contentType="text/html; charset=UTF8"
    		pageEncoding="UTF8"%>
    		- language="java" => 해당 JSP 페이지에서 사용 되는 언어가 (java)
    		- contentType : 문서의 타입
    		- charset : 문자 셋(UTF-8, EUC-KR)
    		- isErrorPage : 에러페이지인지의 여부를 지정
    		- errorPage : 에러페이지 발생시 보여줄 페이지를 지정
	 --%>
</body>
</html>