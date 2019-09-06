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
		<hr width="50%" color="aqua">
		<h3>BOARD 테이블에 게시물 글쓰기 폼</h3>
		<hr width="50%" color="aqua">
		<br>
		<form method="post" action="<%=request.getContextPath()%>/insert">
			<table border="1" width="400" cellspacing="0">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="8" cols="40" name="content"></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit"value="글 작성">&nbsp;&nbsp;&nbsp;
					 <input type="reset"value="취소">
					 </td>
			</table>
		</form>
	</div>
</body>
</html>