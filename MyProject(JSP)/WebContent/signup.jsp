<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript">

</script>
</head>
<body>
<h3>기본 정보</h3>
<form method="post" action="<%=request.getContextPath()%>/usersignup">

	<!-- <table border="3" cellspacing="0" cellpadding="10" name ="table"> -->
	<table>
		<tr>
			<th width="250">아이디</th>
			<td align="left">
			<input type="text" style="width: 100px;" name="id">&nbsp;
			<input type="button" value="중복 확인">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td align="left"><input type="password" style="width: 100px;" name="pwd">&nbsp;<font color="gray" size="2">영문/숫자 조합으로 8~16자리, 첫글자는 영문자로 사용</font>
			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td align="left"><input type="password" style="width: 100px;" name="pwd2">&nbsp;<font color="gray" size="2">비밀번호를 한번 더 입력하세요</font>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td align="left"><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td align="left">r
			<input type="radio" name = "gender" value="남 "checked>남자
			<input type="radio" name = "gender" value="여">여자
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td align="left">
			<input type="text">@
			<select>
				<option value=""> 직접 입력 </option>
				<option value="네이버">naver.com</option>
				<option value="구글">gmail.com</option>
				<option value="다음">hanmail.net</option>
				<option value="네이트">nate.com</option>
				<option value="쌍용">sist.com</option>
			</select>
			<input type="text">
			</td>
			
		</tr>
		<tr>
			<th>이메일 수신 여부</th>
			<td align="left">
			 <input type="checkbox" name ="hobby" value="수신"> 수신
			 <input type="checkbox" name ="hobby" value="수신안함">수신안함
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td align="left">
			<input type="radio" name = "phone" value="skt "checked>SKT
			<input type="radio" name = "phone" value="kt">KT
			<input type="radio" name = "phone" value="lg">LGU+ <br>
			<select>
				<option value="010"> 010 </option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
			</select>
			-<input type="text" style="width: 70px;">-<input type="text" style="width: 70px;">
			</td>
		</tr>
		<tr height="20">
			<th>비밀번호 확인시 질문</th>
			<td align="left">
			<select>
				<option value=""> 선 택 </option>
				<option value="나이">당신의 나이는?</option>
				<option value="도시">당신이 사는 도시는?</option>
				<option value="음식">좋아하는 음식?</option>
			</select>
			
			</td>
		</tr>
		<tr height="20">
			<th>비밀번호 확인시 답변</th>
			<td align="left"><input type="text"></td>
		</tr>
		<tr>
			<th>회원 이미지</th>
			<td align="left"><input type="file"></td>
		</tr>

	</table>
	<br><br>
	<input type="submit" value="회원 가입" >
	<input type="reset" value="다시 작성">
	
</form>

<!-- <h3>부가 정보</h3>
<form>
	<table border="3" cellspacing="0" cellpadding="10">
	<tr>
		<th>관심</th> 
		<td align="left">
		<input type="checkbox" name ="hobby" value=""> 쇼핑
		<input type="checkbox" name ="hobby" value=""> 음악
		<input type="checkbox" name ="hobby" value=""> 영화 
		</td>
	</tr>
	<tr>
		<th>자기소개</th> 
		<td align="left"> <textarea rows="8" cols="40">하고 싶은 말을 적어주세요</textarea> 
		</td>
	</tr>
</table>
</form> -->
<hr>

</body>
</html>