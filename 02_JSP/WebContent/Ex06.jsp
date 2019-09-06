<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	request.setCharacterEncoding("UTF-8");
 	String id = request.getParameter("id").trim();
 	String pwd = request.getParameter("pwd").trim();
  
 	// 원래는 DB에서 검색 id와 pwd 맞는 회원이 있는지 여부 검색
 	// 맞으면 회원 메인 페이지로 이동
 	
 	if(id.equals("hong")&&pwd.equals("1234")) { // 아이디가 hong, 비밀번호가 1234 회원 메인페이지로 이동
 		RequestDispatcher rd = request.getRequestDispatcher("Ex07.jsp"); // 이동 위치에 내가 입력한 id, pwd 정보가 그대로 넘어 감 
		rd.forward(request, response); // 실제로 페이지 이동 메서드
 	} else {
 		response.sendRedirect("Ex05.jsp");
 	}
 %>
 
 
 