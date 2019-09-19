<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입 폼</title>

<%-- 회원 가입 스타일 적용 파일 링크 --%>
<link rel="stylesheet" type="text/css" href="css/member.css">
<%-- jquery 라이브러리 링크 --%>
<script type="text/javascript" src="js/jquery-3.4.1.js"> </script>
<%-- 회원 가입에 있어서 데이터를 검증하는 외부 자바스크립트 파일 링크 --%>
<script type="text/javascript" src="js/member.js"> </script>
<script type="text/javascript">

// 현재 웹 문서가 브라우저로 로딩 될 때 문서의 본문을 읽고 현재의 제이쿼리를 호출
$(function() {
	// 회원 가입 폼 중에서 아이디 중복 체크라는 버튼에 마우스가 올라 갔을 때
	$("#idcheck_btn").click(function(){
	//$("#idcheck_btn").mouseover(function(){
		$("#idcheck").hide(); // span태그 idcheck 영역을 숨긴다.
		var userId = $("#member_id").val();
		
		// 입력 길이를 체크
		if ($.trim($("#member_id").val()).length < 4) {
			var warningTxt = '<font color="red">아이디는 4자 이상이어야 합니다.</font>';
			$("#idcheck").text(''); // idcheck 영역 초기화
			$("#idcheck").show(); //span태그 idcheck 영역을 보여주기
			$("#idcheck").append(warningTxt);
			$("#member_id").val('').focus();
			return false;
			};
		if ($.trim($("#member_id").val()).length > 16) {
			var warningTxt = '<font color="red">아이디는 16자 미만이어야 합니다.</font>';
			$("#idcheck").text(''); // idcheck 영역 초기화
			$("#idcheck").show(); //span태그 idcheck 영역을 보여주기
			$("#idcheck").append(warningTxt);
			$("#member_id").val('').focus();
			return false;
		};
		
		/*	
		Ajax는 자바 스크립트와 xml을 이용한 비동기 통신 처리를 구현하는 기술
		자바스크립트를 이용하여 서버에서 데이터를 가져와 페이지 전체에 갱신이 없이
		특정 부분만 변경하는 것이 가능하도록 하기 위한 기술
		지금은 많은 부분에서 Ajax 기술이 적용이 되어 있음.
		* 사용 이유: 새로 고침을 통해서 새로운 컨텐츠를 반영하지 않고, 동적인 웹페이지를 구현할 수 있으며, 특정 영역의 데이터 만을 
		따로 서버에서 받아들일 수 있으므로 서버의 네트워크 부하를 줄여줄 수 있음
		*/
		
		$.ajax({
			type : "post", // 데이터 전송 방식	
			url : "idcheck.jsp", // 파일 주소와 경로
			// userId 변수에 userId 값을 저장하여 넘긴다.
			data : {"userId" : userId}, 
			datatype : "jsp", // 통신 할 문서의 데이터 타입
			// 통신이 성공 한 경우 결과 값을 data라는 변수에 저장
			success : function(data) {
				if(data == 1) { // id가 존재하는 경우(중복)
				var warningTxt = '<font color="red">중복 아이디 입니다.</font>';
				$("#idcheck").text(''); // idcheck 영역 초기화
				$("#idcheck").show(); //span태그 idcheck 영역을 보여주기
				$("#idcheck").append(warningTxt);
				$("#member_id").val('').focus();
				return false;
			} else{ // 아이디가 중복이 되지 않는 경우
				var warningTxt = '<font color="blue">사용 가능한 아이디 입니다.</font>';
				$("#idcheck").text(''); // idcheck 영역 초기화
				$("#idcheck").show(); //span태그 idcheck 영역을 보여주기
				$("#idcheck").append(warningTxt);
				$("#member_pass").val('').focus();
				return false;
			}
			},				
			error : function() { // 비동기 통신이 실패한 경우
				alert("data error");
			} 
		}); // Ajax end
		return false;
		});
	});
</script>

</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
		<h2>회원 가입</h2>
		<hr width="50%" color="red">
		
		<div id ="join_wrap">
		<form name="f" method="post" action="<%=request.getContextPath()%>/join_ok.do" onsubmit="return mem_check()"> <!-- 서브밋 버튼을 누르면 mem_check()를 호출  -->
		<table id="join_t">
		<tr>
		
			<th>회원 아이디</th>
			<td><input name="member_id" id="member_id" size="14">
			<input type="button" value="아이디 중복 체크" id="idcheck_btn" onclick="test()">
			<br>
			<%-- 경고문이 출력되는 위치 --%>
			<span id="idcheck"> </span>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="member_pass" name="member_pass" size="14"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			
			<td><input type="password" id="member_pass2" name="member_pass2" size="14"></td>
		</tr>
		<tr>
			<th>회원 이름</th>
			<td><input name="member_name" id="member_name" size="14"></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input name="member_nickname" id="member_nickname" size="20"></td>
		</tr>
		<tr>	
			<th>우편번호</th>
			<td>
			<input name="member_zip1" id="member_zip1" size="3" readonly onclick="post_search()">
			<input name="member_zip2" id="member_zip2" size="3" readonly onclick="post_search()">
			<input type="button" value="우편번호 찾기" onclick="post_check()">
			</td>
		</tr>
		<tr>
			<th>주 소</th>
			<td><input name="member_addr1" id="member_addr1" size="50" readonly onclick="post_search()"></td>
		</tr>
		<tr>
			<th>나머지 주소</th>
			<td><input name="member_addr2" id="member_addr2" size="50"></td>
		</tr>					
		</table>
		
				<div id="join_menu">
					<input type="submit" value="가입하기">
					 <input type="reset" value="다시 작성">
				</div> <%-- id = "join_menu" end --%>
			</form>
		</div>
	</div>
</body>
</html>