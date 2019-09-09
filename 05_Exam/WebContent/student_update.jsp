<%@page import="com.sist.model.StudentDTO"%>
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
<title>학생 정보 수정 </title>
</head>
<body>
<div align="center">
	<hr width="50%" color="green">
		<h3>학생 상세 정보 수정</h3>
		<hr width="50%" color="green">
		<br><br>
		
		<form method="post" action="<%=request.getContextPath()%>/update">
		<table border="1" cellspacing="0" >
		<tr>
				<th width="100">학 번(수정 불가)</th>
				<th width="50">이 름</th>
				<th width="50">아이디</th>
				<th width="100">비밀번호</th>
				<th width="200">전화번호</th>
				<th width="100">전 공</th>
				<th>학 년</th>
				<th width="150">등록 날짜(수정 불가)</th>
			</tr>

			<%
				
			%>
			<tr>
				<td><input type="text" name ="hakbun" value="<%=dto.getHakbun()%>"readonly></td>
				<td><input type="text" name="name" value="<%=dto.getName()%>"></td>
				<td><input type="text" name="id" value="<%=dto.getId()%>"></td>
				<td><input type="password" name="pwd" value="<%=dto.getPwd()%>"></td>
				<td><input type="text" name="tel" value="<%=dto.getTel()%>"></td>
				<td><input type="text" name="major" value="<%=dto.getMajor()%>"></td>
				<td><input type="text" name="grade" value="<%=dto.getGrade()%>"></td>
				<td><input type="text" value="<%=dto.getReg_date().substring(0, 10)%>" readonly></td>
				
			</tr>
		</table>
			<input type="submit" value="수정 완료">
			<input type="reset" value="수정 취소">
		</form>
		
			
	</div>
</body>
</html>