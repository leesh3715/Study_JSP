<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	request.setCharacterEncoding("UTF-8");
 	String id = request.getParameter("id").trim();
 	String pwd = request.getParameter("pwd").trim();
  
 	// 원래는 DB에서 검색 id와 pwd 맞는 회원이 있는지 여부 검색
 	// 맞으면 회원 메인 페이지로 이동
 	
 	if(id.equals("hong")&&pwd.equals("1234")) { // 아이디가 hong, 비밀번호가 1234 회원 메인페이지로 이동
 		response.sendRedirect("Ex11.jsp");
 	} else {
 		response.sendRedirect("Ex12.jsp");
 	}
 %>
 
 
 