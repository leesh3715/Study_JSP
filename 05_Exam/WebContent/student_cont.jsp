<%@page import="com.sist.model.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.model.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int hakbun = Integer.parseInt(request.getParameter("hakbun"));
	StudentDAO dao = new StudentDAO();
	StudentDTO dto = dao.studentCont(hakbun);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<div align="center">
	<hr width="50%" color="yellow">
		<h3>학생 상세 정보 출력</h3>
		<hr width="50%" color="yellow">
		<br><br>
		<table border="1" cellspacing="0" >
		<tr>
				<th width="100">학 번</th>
				<th width="50">이 름</th>
				<th width="50">아이디</th>
				<th width="100">비밀번호</th>
				<th width="200">전화번호</th>
				<th width="100">전 공</th>
				<th>학 년</th>
				<th width="150">등록 날짜</th>
			</tr>

			<%
				
			%>
			<tr>
				<td><%=dto.getHakbun()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getPwd()%></td>
				<td><%=dto.getTel()%></td>
				<td><%=dto.getMajor()%></td>
				<td><%=dto.getGrade()%></td>
				<td><%=dto.getReg_date().substring(0, 10)%></td>
				
			</tr>
		</table>
		<br><br>
			<a href="student_update.jsp?hakbun=<%=hakbun%>">[수정]</a>
			<a href="student_delete.jsp?hakbun=<%=hakbun%>">[삭제]</a>
			<a href="select">[목록]</a>
	</div>
</body>
</html>