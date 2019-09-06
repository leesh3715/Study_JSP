<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원 가입</h2>
	<form method="post" action="Ex04_01.jsp">
	  <table border="1" width="400">
	  	<tr>
	  		<th>아이디</th>
	  		<td> <input type="text" name="id"> </td>
	  	</tr>
	  	<tr>
	  		<th>비밀번호</th>
	  		<td> <input type="password" name="pwd"> </td>
	  	</tr>
	  	<tr>
	  		<th>이 름</th>
	  		<td> <input type="text" name="name"> </td>
	  	</tr>
	  	<tr>
	  		<th>성 별</th>
	  		<td>
	  			<input type="radio" name="gender" value="남">남자
	  				&nbsp;&nbsp;&nbsp;
	  			<input type="radio" name="gender" value="여">여자
	  		</td>
	  	</tr>
	  	<tr>
	  		<th>취 미</th>
	  		<td>
	  		  <input type="checkbox" name="hobby" value="숨쉬기">숨쉬기
		      <input type="checkbox" name="hobby" value="게임">게임
		      <input type="checkbox" name="hobby" value="여행">여행
		      <input type="checkbox" name="hobby" value="먹기">먹기
		      <input type="checkbox" name="hobby" value="잠자기">잠자기
	  		</td>
	  	</tr>
	  	<tr>
	  		<th>이메일</th>
	  		<td> <input type="text" name="email"> </td>
	  	</tr>
	  	<tr>
	  		<th>거주지</th>
	  		<td>
	  			<select name="addr">
	  				<option value="" selected>:::선택하세요:::</option>
	  				<option value="서울">서울</option>
	  				<option value="부산">부산</option>
	  				<option value="대전">대전</option>
	  				<option value="대구">대구</option>
	  				<option value="광주">광주</option>
	  			</select>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center">
	  			<input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
	  			<input type="reset" value="취소">
	  		</td>
	  	</tr>
	  </table>
	</form>
	
</body>
</html>