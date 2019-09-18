<%@page import="com.paging.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("userId");
	// DB와 연동
	MemberDAO dao = new MemberDAO();
	int res = dao.checkMemberId(id);
	System.out.println(res);
	out.println(res); // 출력을 하면 바로 결과 값을 넘겨줄 수 있음 바로 넘어감
%>
