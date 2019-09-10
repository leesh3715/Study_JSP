<%@page import="com.sist.model.Board1_DTO"%>
<%@page import="com.sist.model.Board1_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int board_no = Integer.parseInt(request.getParameter("no"));
	
	Board1_DAO dao = new Board1_DAO();
	dao.boardHit(board_no); // 조회수 증가 메서드 호출, 여기서 DB를 닫아버리면 뒤에서 DB연결이 되지 않음, 그래서 DB를 닫으면 안됨 
	Board1_DTO dto = dao.boardcont(board_no); // 글번호를 이용해서 상세 내용 조회하는 메서드 호출
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<table border="1" width="400" cellspacing="0">
			<%
		if (dto != null) { // 검색된 레코드가 있는 경우
	%>
			<tr>
				<th colspan="2">
					<h3><%=dto.getBoard_writer()%>님 게시물 상세 내역
					</h3>
				</th>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=dto.getBoard_writer()%></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><%=dto.getBoard_title()%></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="8" cols="40" readonly><%=dto.getBoard_cont()%>
				</textarea></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=dto.getBoard_hit()%></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><%=dto.getBoard_regdate()%></td>
			</tr>

			<% } else { %>
			<tr>

				<td colspan="2" align="center">
					<h3>검색된 레코드가 없습니다.</h3>
				</td>
			</tr>
			<% 	}	%>
			
			<tr>
				<td colspan="2" align="center">
				<a href="board_update.jsp?no=<%=board_no%>">[수정]</a>
				 <a href="board_delete.jsp?no=<%=board_no%>">[삭제]</a> <a href="select">[목록]</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>