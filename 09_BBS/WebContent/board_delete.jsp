<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="purple">
		<h3>게시판 정보 삭제</h3>
		<hr width="50%" color="purple">
		<br>

		<form method="post" action="<%=request.getContextPath()%>/delete_ok.do">
		<input type="hidden" name="no" value="<%=no%>">
			<table border="1" cellspacing="0">
				<tr>
				<td>비밀번호: <input type="password" name ="pwd">&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
				<td>글번호 :<%=no%></td>
				</tr>			
			</table>
			<br>
				<input type="submit" value="삭제 완료">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="삭제 취소">	
		</form>
	</div>
</body>
</html>