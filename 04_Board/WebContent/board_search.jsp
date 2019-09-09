<%@page import="com.sist.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	ArrayList<BoardDTO> list =  (ArrayList<BoardDTO>)request.getAttribute("Search");
 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<hr width="50" color="orange">
	<h3>BOARD 테이블 게시물 검색 결과 리스트</h3>
	<hr width="50" color="orange">
	<table border="1" width="400" cellspacing="0">
	<tr>
		<th>글번호</th> <th><a>글제목</a></th>
		<th>조회수</th> <th>작성일자</th>
	</tr>
	<%
	if(list.size()!=0){
		for(int i=0;i<list.size();i++) {
			BoardDTO dto =  list.get(i); %>
			<tr>
			<td><%=dto.getBoard_no() %></td>
			<td><a href="board_cont.jsp?no=<%= dto.getBoard_no()%>">
                  <%= dto.getBoard_title() %></a></td>
			<td><%=dto.getBoard_hit()%></td>
			<td><%=dto.getBoard_regdate().substring(0,10)%></td>
			</tr>
		<%}
	}else{ %>
		<tr>
			<td colspan="4" align="center">
				<h3>검색된 레코드가 없습니다.</h3>
			</td>
		</tr>
	<%}%>
		<tr>
		<td colspan="4" align="right">
				<a href="<%=request.getContextPath()%>/select">[목록]</a>
			</td>
		</tr>
	
	</table>
		
	</div>
</body>
</html>