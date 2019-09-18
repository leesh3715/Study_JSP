<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"> </script>
<script type="text/javascript" src="js/member.js"> </script>
<script>

	// 아이디와 비밀번호 유효성 체크하는 함수
	function check(){
		if($.trim($("#id").val())=="") {
			alert("아이디를 입력 하세요..");
			$("#id").focus();
			return false;
		}
		if($.trim($("#pwd").val())=="") {
			alert("비밀번호를 입력 하세요..");
			$("#pwd").focus();
			return false;
		}
	}
	
	function find_pwd(){
		window.open("pwd_find.do", "비번 찾기", "width=300 height=300");
	}
</script>
</head>
<body>
	<div align="center">
		<hr width="50%" color="gray">
		<h3>회원 로그인 화면</h3>
		<hr width="50%" color="gray">
		<form method="post" action="<%=request.getContextPath()%>/login_ok.do" onsubmit="return check()">
		<table border="1" width="300" cellspacing="0">
			<tr>
				<th>아이디</th>
				<td><input name="id" id="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="로그인">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" value="회원 가입" onclick="location.href='join.do'">&nbsp;&nbsp;
				<input type="button" value="비번 찾기" onclick="pwd_find()">
			</tr>
		</table>
		</form>
	</div>
</body>
</html>