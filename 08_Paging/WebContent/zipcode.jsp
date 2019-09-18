<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String zipcode, addr, addr2;
	String dong = (String)request.getAttribute("dong");
	ArrayList zipcodelist = (ArrayList)request.getAttribute("zip");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function check(form) {
		if (form.dong.value == "") {
			alert("동을 입력해주세요");
			form.dong.focus();
			return false;
		}
	}
	
	function selectnow(){
	
		var zip = document.postform.post_list.value;
		var zip1 = zip.substring(0,3);
		var zip2 = zip.substring(4,7);
		var addr2 = zip.substring(7,(zip.length));
		
		//opener: 현재 페이지를 오픈한 주체: 회원 가입 창
		/*
		form name = f
		<tr>	
			<th>우편번호</th>
			<td>
			<input name="member_zip1" id="member_zip1" size="3" readonly onclick="post_search()">
			<input name="member_zip2" id="member_zip2" size="3" readonly onclick="post_search()">
			<input type="button" value="우편번호 찾기" onclick="post_check()">
			</td>
		</tr>
		*/
		opener.document.f.member_zip1.value = zip1; // 우편번호 앞 3자리
		opener.document.f.member_zip2.value = zip2; // 우편번호 앞 3자리
		opener.document.f.member_addr1.value = addr2; // 우편번호 앞 3자리
		
		parent.window.close(); // 그 후에 윈도우 창을 닫아 줌
	}

	/* $(function check(form)) {
	 if(form.dong.value=="") {
	 alert("동을 입력해주세요");
	 form.dong.focus();
	 return false;
	 }); */

	/* window.onload = function check(form) {
		if(form.dong.value=="") {
			alert("동을 입력해주세요");
			form.dong.focus();
			return false;
		}
	}; */
</script>
</head>
<body bgcolor="#ffffff" topmargin="0" leftmargin="0"
	onload="postform.dong.focus()">
	<!-- 바디 부분을 읽고 onload를 실행 -->
	<form name="postform" method="post"
		action="<%=request.getContextPath()%>/zipcode_ok.do"
		onsubmit="return check(this)">
		<table width="410" height="100" cellspacing="0" align="center">
			<tr>
				<td align="center" bgcolor="#999999"><input type="image"
					src="images/ZipCode_img01.gif" width="413" height="58"></td>
			</tr>
			<tr>
				<td bgcolor="#f5ffea" align="center"><strong><font
						color="#466d1b"> <span class="style1">[거주지의 면, 동을
								입력하고 '찾기' 버튼을 누르세요]</span></font> </strong></td>
			</tr>
			<tr height="30">
				<td bgcolor="#f5ffea" align="center"><input name="dong"
					size="10">&nbsp; <input type="image" src="images/m-i02.gif"
					width="69" height="19"></td>
			</tr>
			<%-- 실제 우편번호가 출력 될 위치--%>
	<%
		if(dong!=null) {
			if(zipcodelist.size() != 0) { %>
				<tr>
					<td bgcolor="#f5ffea" height="30" align="center">
					<select name="post_list" onchange="selectnow()">
					<option value="">:::주소를 선택하세요:::</option>
					<%
						for(int i=0; i<zipcodelist.size(); i++) {
							String data = (String)zipcodelist.get(i);
							StringTokenizer st = new StringTokenizer(data,","); // data를 ,를 기준으로 잘라줌
							zipcode = st.nextToken();
							addr = st.nextToken();
							addr2 = st.nextToken();
							String totalAddr = zipcode + addr; %>
							
						<option value="<%=totalAddr %>">[<%=zipcode %>]&nbsp;<%=addr %></option>
						<%} %>
					</select>
					</tr>
						<% }else { %>
					<tr>
            	   	<td bgcolor="#F5FFEA" height="30" align="center">
               		<font color="#466D1B"><span class="style1">검색 결과가 없습니다.</span></font>
						</td>
					</tr>
			<%	} }%>
		<tr>
			<td bgcolor="#508c0f" colspan="3" height="3"></td>
		</tr>
		</table>
	</form>
	
	</body>
</html>