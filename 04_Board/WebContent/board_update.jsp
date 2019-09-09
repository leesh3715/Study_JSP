<%@page import="com.sist.model.BoardDTO"%>
<%@page import="com.sist.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int board_no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.boardcont(board_no);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="brown">
		<h3>BOARD 테이블 게시물 수정 폼</h3>
		<hr width="50%" color="brown">
		<form method="post" action="<%=request.getContextPath()%>/update">
			<%-- 게시글 번호를 hidden 타입으로 숨겨서 다른 데이터 들과 같이 넘겨 줌  --%>
			<%-- <form> 태그에는 보이지 않고 데이터를 전송하는 속성 --%>
			<input type="hidden" name="num" value="<%=board_no%>">
			
			<table border="1" width="400" cellspacing="0">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"
						value="<%=dto.getBoard_writer()%>" readonly></td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td><input type="text" name="title"
						value="<%=dto.getBoard_title()%>"></td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="8" cols="30" name="content"><%=dto.getBoard_cont()%></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
						<%-- value="<%=dto.getBoard_pwd()%>"> --%>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit"
						value="글 수정">&nbsp;&nbsp;&nbsp; 
						<input type="reset"
						value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>