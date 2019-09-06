<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int board_no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="gray">
		<h3>BOARD 테이블 게시글 삭제 폼</h3>
		<hr width="50%" color="gray">
		<form method="post" action="<%=request.getContextPath()%>/delete">
			<input type="hidden" name="board_no" value="<%=board_no%>">
			<table border="1" width="250" cellspacing="0">
				<tr>
					<th>삭제할 비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 삭제">&nbsp;&nbsp;&nbsp; <input type="reset"
						value="취소"></td>
				</tr>
			</table>



		</form>

	</div>
</body>
</html>