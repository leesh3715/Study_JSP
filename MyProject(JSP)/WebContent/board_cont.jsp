<%@page import="com.sist.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.model.MangoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- common CSS -->

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
<style>
.navbar-nav {
        margin: 0 auto;
        display: table;
        table-layout: auto;
        float: none;
        width: 100%;
    }
    .navbar-nav>li {
        display: table-cell;
        float: none;
        text-align: center;
    }
</style>
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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" style="text-align: center">
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">홈</a></li>
        <li><a href="home.jsp">Mango chart</a></li>
        <li><a href="<%=request.getContextPath()%>/select.do">자유게시판</a></li> 
        <li class="dropdown">
          <a href="mymusic.jsp" class="dropdown-toggle" data-toggle="dropdown">마이 페이지<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">3-1번 메뉴</a></li>
            <li><a href="#">3-2번 메뉴</a></li>
            <li><a href="#">3-3번 메뉴</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">네비게이션 헤더</li>
            <li><a href="#">3-4번 메뉴</a></li>
            <li><a href="#">3-5번 메뉴</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
		<!-- 문서의 절: 여러 개 사용  -->
		<div id="contentDiv" align="center">
			<section id="content">
				<article>
				<hr width="500" color="pink">
						<h3>Mango Music 자유게시판 상세내역</h3>
						<hr width="500" color="pink">
						<br> <br>
					<!-- 문서의 본문 내용 -->
					<table class = "table table-dark" border="1" width="400" cellspacing="0">
			<c:set var="dto" value="${Cont }" />
			<c:if test="${!empty dto }">
				<tr>
					<th>작성자</th>
					<td>${dto.getBoard_writer() }</td>
				</tr>
				<tr>
					<th>글제목</th>
					<td>${dto.getBoard_title() }</td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="8" cols="30" readonly>${dto.getBoard_cont() }</textarea></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${dto.getBoard_hit() }</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${dto.getBoard_date() }</td>
				</tr>
			</c:if>
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 레코드가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<tr>
			<td colspan="2" align="center">
			<input class = "btn btn-info" type="button" value="수정" onclick="location.href='edit.do?no=${dto.getBoard_no()}'">
			<input class = "btn btn-danger" type="button" value="삭제" onclick="location.href='delete.do?no=${dto.getBoard_no()}'">
			<input class = "btn btn-danger"type="button" value="답변" onclick="location.href='reply.do?no=${dto.getBoard_no()}'">
			<input class = "btn btn-primary" type="button" value="목록" onclick="location.href='select.do'">
			</td>
			</tr>
		</table>
					
				</article>
			</section>
		</div>

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