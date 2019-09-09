<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int hakbun = Integer.parseInt(request.getParameter("hakbun"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 정보 삭제</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="purple">
		<h3>학생 상세 정보 삭제</h3>
		<hr width="50%" color="purple">
		<br>

		<form method="post" action="<%=request.getContextPath()%>/delete">
			<table border="1" cellspacing="0">
				<tr>
				<h3>학생 정보 삭제를 위해 학번과 비밀번호를 입력 해 주세요</h3>
				<td>학번: <input type="text" name ="hakbun">&nbsp;&nbsp;&nbsp;</td>
				<td>비밀번호: <input type="password" name ="pwd">&nbsp;&nbsp;&nbsp;</td>
				</tr>				
			</table>
			<br>
				<input type="submit" value="삭제 완료">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="삭제 취소">	
		</form>

	</div>
</body>
</html>