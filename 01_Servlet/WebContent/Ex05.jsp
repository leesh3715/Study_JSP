<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>성 적 처 리</h2>
	<form method="get" action="score">
	  <table border="1" width="300">
	  	<tr>
	  		<th>이 름</th>
	  		<td> <input type="text" name="name"> </td>
	  	</tr>
	  	<tr>
	  		<th>국어점수</th>
	  		<td> <input type="text" name="kor"> </td>
	  	</tr>
	  	<tr>
	  		<th>영어점수</th>
	  		<td> <input type="text" name="eng"> </td>
	  	</tr>
	  	<tr>
	  		<th>수어점수</th>
	  		<td> <input type="text" name="mat"> </td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center">
	  			<input type="submit" value="성적처리">&nbsp;&nbsp;&nbsp;
	  			<input type="reset" value="취소"> 
	  		</td>
	  	</tr>
	  </table>
	</form>
</body>
</html>