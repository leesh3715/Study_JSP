<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	
	
	if(age>=20){
		response.sendRedirect("pass.jsp?nai="+age);
	}else{
		response.sendRedirect("nopass.jsp?nai="+age);
	}



%>