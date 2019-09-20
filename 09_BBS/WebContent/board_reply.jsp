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
	<hr width="50%" color="orange">
	<h3>JSP_BBS 테이블 게시글 답변 폼</h3>
	<hr width="50%" color="orange">
	<form method="post" action="<%=request.getContextPath() %>/reply_ok.do">
	<table border="1" width="400" cellspacing="0">
	<c:set var="dto" value="${reply }"/>
	<c:if test="${!empty dto }">
	<%-- 히든 4개 --%>
	<input type="hidden" name="board_no" value="${dto.getBoard_no() }">
	<input type="hidden" name="board_group" value="${dto.getBoard_group() }">
	<input type="hidden" name="board_step" value="${dto.getBoard_step() }">
	<input type="hidden" name="board_indent" value="${dto.getBoard_indent() }">
	
		<tr>
			<th>작성자</th>
			<td><input name="writer" value="${dto.getBoard_writer() }">
			</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input name="title" value="${dto.getBoard_title() }">
			</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="8" cols="30" name="cont">${dto.getBoard_cont() }</textarea>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="답변">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
			</td>
		</tr>
	</c:if>
	</table>
	</form>
	</div>
</body>
</html>