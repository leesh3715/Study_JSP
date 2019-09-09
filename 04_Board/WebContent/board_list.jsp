<%@page import="com.sist.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("LIST");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<hr width="500" color="pink">
		<h3>BOARD1 테이블 게시물 목록</h3>

		<hr width="500" color="pink">
		<br> <br>
		<table border="1" width="500" cellspacing="0">
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>조회수</th>
				<th>작성일자</th>
			</tr>
			<%
				if (list.size() != 0) { // 검색된 레코드가 있는 경우
					// 검색 된 레코드 수 만큼 반복해서 화면에 출력
					for(int i =0; i<list.size(); i++) {
						BoardDTO dto = list.get(i); %>
			<tr>
				<td><%=dto.getBoard_no()%></td>
				<td><a href="board_cont.jsp?no=<%=dto.getBoard_no()%>"> <%=dto.getBoard_title()%></a></td>
				<td><%=dto.getBoard_hit()%></td>
				<td><%=dto.getBoard_regdate().substring(0,11)%></td>
			</tr>
			<% }
				} else { // 데이터가 없는 경우
					%>
			<tr>
				<td colspan="4" align="center">
					<h3>검색된 레코드가 없습니다.</h3>
				</td>
			</tr>
			<% }%>
		</table>
		<br>
		<hr width="50%" color="pink">
		<br>
		<br> 
		<input type="button" value="글쓰기"
			onclick="location.href='board_write.jsp'"> <br>
		<br>

		<form method="post" action="<%=request.getContextPath()%>/search">
			<select name="find_field">
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">제목+내용</option>
				<option value="4">작성자</option>
			</select>
			 <input type="text" name="find_name" size="15">
			 <input type="submit" value="검색">
		</form>
	</div>
</body>
</html>