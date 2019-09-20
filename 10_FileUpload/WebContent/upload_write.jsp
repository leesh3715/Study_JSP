<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="orange">
		<h3>UPLOAD 테이블 게시글 입력 폼</h3>
		<hr width="50%" color="orange">
		<form method="post" action="<%=request.getContextPath() %>/upload_write_ok.do" enctype="multipart/form-data">
		<%--enctype: 이진 파일 업로드 하기 위한 속성 --%>
		<table border="1" width="400" cellspacing="0">
		<tr>
			<th>작성자</th>
			<td><input name="writer"></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input name="title"></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="8" cols="30" name="cont"></textarea></td>
		</tr>
		<tr>
			<th>파일첨부</th>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="글추가">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소"></td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>