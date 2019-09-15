<%@page import="com.sist.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.model.MangoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("LIST");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY JSP PROJECT</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link type="text/css" href="boot/bootstrap.css" rel="stylesheet">
<!-- 부가적인 테마 -->
<link type="text/css" href="boot/bootstrap-theme.css" rel="stylesheet">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="boot/bootstrap.js"></script>
<script type="text/javascript">
	/* 사용자 정의 함수  */
	function login_window() {
		// 새로운 창을 열라는 명령어
		window.open("login.jsp", "로그인", "width=300px,height=250px") // 초기  사이즈 셋팅
		//window.open("파일명", "창의 이름", "폭/높이")
	}
	function signUp_window() {
		window.open("signup.jsp", "회원 가입", "width=500px,height=800px") // 초기  사이즈 셋팅
	}
</script>
</head>
<body>
	<div id="container">
		<header>
			<!-- 머릿말 영역 -->
			<div id="login">
				<a href="index.jsp">홈</a> <a href="#" onclick="login_window()">로그인</a>
				<a href="#" onclick="signUp_window()">회원가입</a>
			</div>
			<!-- id="login" end  -->
			<hgroup>
				<!-- hgroup 제목과 부제목을 그룹으로 묶어주는 역할   -->
				<h1>Mango Board</h1>

			</hgroup>
		</header>
		<!-- 네비게이션 영역  -->
		<nav id="nav">
			<ul>
				<li><a href="index.jsp">망고 차트</a></li>
				<li><a href="board.jsp">게시판</a></li>
				<li><a href="mymusic.jsp">마이 뮤직</a></li>
				<li><a href="etc.jsp">기 타</a></li>
			</ul>
		</nav>
		<!-- 문서의 절: 여러 개 사용  -->
		<section id="content">
			<h2 class="text-warning  bg-success mangoboard ">Mango Music</h2>
			<article>
				<!-- 문서의 본문 내용 -->
				<div align="center">
					<hr width="500" color="pink">
					<h3>Mango Music 자유게시판</h3>

					<hr width="500" color="pink">
					<br> <br>
					<table border="1" width="500" cellspacing="0">
						<tr>
							<th>글 번호</th>
							<th>글 제목</th>
							<th>조회수</th>
							<th>작성일자</th>
						</tr>
						<%
							if (list.size() != 0) { // 검색된 레코드가 있는 경우
								// 검색 된 레코드 수 만큼 반복해서 화면에 출력
								for (int i = 0; i < list.size(); i++) {
									BoardDTO dto = list.get(i);
						%>
						<tr>
							<td><%=dto.getBoard_no()%></td>
							<td><a href="board_cont.jsp?no=<%=dto.getBoard_no()%>">
									<%=dto.getBoard_title()%></a></td>
							<td><%=dto.getBoard_hit()%></td>
							<td><%=dto.getBoard_regdate().substring(0, 11)%></td>
						</tr>
						<%
							}
							} else { // 데이터가 없는 경우
						%>
						<tr>
							<td colspan="4" align="center">
								<h3>검색된 레코드가 없습니다.</h3>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<br>
					<hr width="50%" color="pink">
					<br> <br> <input type="button" value="글쓰기"
						onclick="location.href='board_write.jsp'"> <br> <br>

					<form method="post" action="<%=request.getContextPath()%>/search">
						<select name="find_field">
							<option value="1">제목</option>
							<option value="2">내용</option>
							<option value="3">제목+내용</option>
							<option value="4">작성자</option>
						</select> <input type="text" name="find_name" size="15"> <input
							type="submit" value="검색">
					</form>
				</div>

			</article>
		</section>
		<!-- 문서의 보조 내용(알림, 광고 등등)  -->
		<aside id="sidebar">
			<div class="loginDiv">
				<br>
				<p>
					망고를 더 안전하게 이용하세요&nbsp;&nbsp; <a href="signup.jsp">회원가입</a>
				</p>
				<br> <input type="button" class="btn btn-success btn-block"
					value="로그인" onclick="login_window()">
			</div>
			<br> <img src="images/jazz.jpg" width="280" height="200">
			<br> <br>
			<div class="chartDiv">
				<ul class="nav nav-pills nav-justified">
					<li role="presentation" class="active"><a href="#1">실시간</a></li>
					<li role="presentation"><a href="#2">POP</a></li>
					<li role="presentation"><a href="#3">아티스트</a></li>
				</ul>
			</div>
			<!-- <p>저서 구입을 원하시는 분들은 전화 010-1111-1234로
				연락 주시기 바랍니다.</p>
				
				<img src="images/book2.png" width="130" height="160"> -->
		</aside>
		<!-- 꼬릿말 하단 영역  -->
		<footer>
			<address>E-mail: lsh3715@gmail.com</address>
			<p>Copyright & copy All right reserved</p>
		</footer>
	</div>
	<!-- id="container" end  -->
</body>
</html>