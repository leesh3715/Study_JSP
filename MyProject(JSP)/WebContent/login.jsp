<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="login_wrap">
		<h2 class="login_title">회원 로그인</h2>
		<form name="frm" method="post" action="<%=request.getContextPath()%>/userlogin.do">
		<table id ="login_t">
			<tr>
				<th>아이디</th>
				<td> <input type= "text" size="14" class="input_box" name="id"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input type= "password" size="14" class="input_box" name="pwd"> </td>
			</tr>
		</table>
		
		<div id="login_menu">
			<input type ="submit" value="로그인" class="login_b" onclick="window.close()">
			<input type ="reset" value="취소" class="login_b">
		</div> <!--  <div id="login_menu"> -->
		</form>
	</div> <!--<div id="login_wrap">  -->

</body>
</html>