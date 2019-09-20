<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
		<h3>UPLOAD 테이블 전체 리스트</h3>
		<hr width="50%" color="red">
		<table border="1" width="400" cellspacing="0">
			<tr>
				<th>글번호</th> <th>글제목</th>
				<th>조회수</th> <th>작성일자</th>
			</tr>
			<c:set var="list" value="${uploadList }"/>
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
				<tr>
				<td>${dto.getUpload_no() }</td>
				<td><a href="upload_cont.do?no=${dto.getUpload_no() }">
				${dto.getUpload_title() }</a></td>
				<td>${dto.getUpload_hit() }</td>
				<td>${dto.getUpload_date().substring(0,10) }</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
				<td colspan="4" align="center">
					<h3>검색된 레코드가 없습니다.</h3>
				</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="4" align="right">
				<input type = "button" value="글쓰기" onclick="location.href='upload_write.do'">
			</tr>
		</table>
	</div>
</body>
</html>