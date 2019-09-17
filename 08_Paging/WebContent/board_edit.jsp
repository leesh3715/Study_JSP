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
	<hr width="50%" color="purple">
		<h3>MVC-2 모델 게시판 게시글 수정</h3>
	<hr width="50%" color="purple">
	
	<form method="post" action="<%=request.getContextPath()%>/edit_ok.do">
			
	<table border="1" width="400" cellspacing="0">
	
		<c:set var="dto" value="${cont }"/>
				<c:if test="${!empty dto }">
				<input type="hidden" name="no" value="${dto.getBoard_no() }">
				<tr>
					<th>글제목</th>
					<td><input value="${dto.getBoard_title() }" name="title"></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><input value="${dto.getBoard_cont() }" name="cont"></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${dto.getBoard_hit() }</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${dto.getBoard_regdate() }</td>
				</tr>
				<tr>
				<tr>
					<th>작성자</th>
					<td>${dto.getBoard_writer() }</td>
				</tr>
					<th>비밀번호 확인</th>
					<td><input type="password" value="${dto.getBoard_cont() }" name="pwd"></td>
				</tr>
				</c:if>
				
				<tr>
				<td colspan="2" align="center">
				 <input type="submit" value="수정완료">&nbsp;&nbsp;&nbsp; 
                  <input type="reset" value="취소"></td>
				</tr>
		</table>
		</form>
	</div>
</body>
</html>