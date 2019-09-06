<%@page import="com.sist.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)request.getAttribute("List"); // Object 타입을 형 변환 시켜준 것 ArrayList MembereDTO
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<hr width="50%" color="blue">
	<h3>MEMBER1 테이블 레코드 검색 결과</h3>
	<hr width="50%" color="blue">
	<br>
	<br>
	<br>
	<table border="1" width="400" cellspacing="0">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>등록 날짜</th>
		</tr>
		<%
			if(list.size()!= 0){
				// list 원소 수 만큼 반복해서 출력
				for(int i=0; i<list.size();i++) {
					// 레코드 단위로 가져와서 출력
					MemberDTO dto = list.get(i); %>
		<!-- HTML 영역 -->
		<tr>
			<td><%=dto.getId()%></td>
			<td><%=dto.getPwd()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getReg_date().substring(0,10)%></td>
		</tr>
		<%
			}
			} else {
		%>
		<!-- HTML 영역 -->
		<tr>
			<td colspan="4" align="center">
				<h3>검색된 레코드가 없습니다.</h3>
			</td>

		</tr>
		<%} %>

	</table><br><br>
	<hr width="50%"><br><br>
	<a href="insertForm.jsp">[레코드 추가]</a>
	<a href="updateForm.jsp">[레코드 수정]</a>
	<a href="deleteForm.jsp">[레코드 삭제]</a>
	
	</div>
</body>
</html>