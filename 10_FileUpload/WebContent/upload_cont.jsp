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
		<hr width="50%" color ="red">
			<h3>UPLOAD 테이블 게시물 상세 내역</h3>
		<hr width="50%" color ="red">	
		<table border="1" width="400" cellspacing="0">
		<c:set var="dto" value="${uploadCont }"/>
		<c:if test="${!empty dto }">
		<tr>
			<th>작성자</th>
			<td>${dto.getUpload_writer() }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td>${dto.getUpload_title() }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="8" cols="30" readonly>${dto.getUpload_cont() }</textarea> </td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><a href="./upload/${dto.getUpload_file() }" target="_blank">${dto.getUpload_file() }</a></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.getUpload_hit() }</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>${dto.getUpload_date() }</td>
		</tr>
		</c:if>
		
		<c:if test="${empty dto }">
			<tr>
			<td colspan="2" align="center">
				<h3>검색된 레코드가 없습니다.</h3>
			</tr>
		</c:if>
		<tr>
		<td colspan="2" align="center">
		<input type="button" value="수정" onclick="location.href='uplode_edit.do?no=${dto.getUpload_no()}'">
		<input type="button" value="삭제" onclick="location.href='uplode_delete.do?no=${dto.getUpload_no()}'">
		<input type="button" value="목록" onclick="location.href='uplode_list.do'">
		</td>
		</tr>
		</table>
	</div>
</body>
</html>