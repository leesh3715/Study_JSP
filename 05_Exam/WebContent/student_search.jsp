<%@page import="com.sist.model.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<StudentDTO> list = (ArrayList<StudentDTO>) request.getAttribute("Search");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 검색정보 출력</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="pink">
		<h3>학생 검색 리스트 출력</h3>
		<hr width="50%" color="pink">
		<br>
		<br>
		<table border="1" cellspacing="0">
			<tr>
				<th width="100">학 번</th>
				<th width="100">이 름</th>
				<th width="100">아이디</th>
				<th width="100">비밀번호</th>
			</tr>

			<%
				
				for (int i = 0; i < list.size(); i++) {
					StudentDTO dto = list.get(i);
			%>
			<tr>
				<td><%=dto.getHakbun()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getPwd()%></td>
				<%
					}
				%>
			</tr>
		</table>
		</div>
	
</body>
</html>