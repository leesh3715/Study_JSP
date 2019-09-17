<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL 태그 라이브러리 사용하기 위해 지시자 설정 --%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center">
	<hr width="50%" color="red">
	<h3>MVC2 모델로 BOARD 테이블 검색 리스트</h3>
	<hr width="50%" color="red">
	
	<table class="table table-hover" width="400" cellspacing="0">
		<tr>
			<th>글 번호</th> <th>글 제목</th>
			<th>조회수</th> <th>등록일자</th>
		</tr>
			<c:set var="list" value="${List }" /> <!-- 파라미터 받는 과정 필요 없이 바로 받을 수 있음 "List"  -->
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
				<tr>
						<td>${dto.getBoard_no() }</td>
						<td><a href="cont.do?no=${dto.getBoard_no()}&page=${page }">${dto.getBoard_title()}</a></td>
						<td>${dto.getBoard_hit() }</td>
						<td>${dto.getBoard_regdate().substring(0,10) }</td>

					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
					<h3>검색된 레코드가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="4" align="center">
				
				<c:if test="${page > block }"> <!-- 페이지가 블럭 3 보다 클 경우  이전으로 가는 버튼 생성 -->
				[<a href="search.do?page=1&find_field=${find_field}&find_name=${find_name}">◀◀</a>] <!-- 무조건 첫번째 페이지로 보내 줌  -->
				[<a href="search.do?page=${startBlock - 1 }&find_field=${find_field}&find_name=${find_name}">◀</a>] <!-- 현재 페이지의 첫번째 블럭에 -1을 해주어 이전 페이지의 마지막 블럭으로 이동  -->
				</c:if>
				
				<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
					<c:if test="${i == page }"> <!-- 현재 페이지랑 i랑 같을때는 언더라인, 굵게 표시  -->
						<u><b>[${i }]</b></u>
					</c:if>
					
					<c:if test="${!(i == page )}"> <!-- 현재 페이지랑 i가 다를 때는 연결할수 있게 링크를 걸어줌, i 에 해당하는 페이지 변수를 받아서  -->
						[<a href="search.do?page=${i }&find_field=${find_field}&find_name=${find_name}">${i }</a>]
					</c:if>				
				</c:forEach>
				
				<c:if test="${endBlock < allPage }"> <!-- 전체 페이지가 마지막 블럭보다 클 경우 다음으로 가는 버튼 생성 -->
				[<a href="search.do?page=${endBlock + 1 }&find_field=${find_field}&find_name=${find_name}">▶</a>] <!-- 현재 페이지의 마지막 블럭에 +1을 해주어 다음 페이지의 첫번째 블럭으로 이동  -->
				[<a href="search.do?page=${allPage }&find_field=${find_field}&find_name=${find_name}">▶▶</a>] <!-- 마지막 페이지의 끝으로 이동  -->
				</c:if>
				</td>
				 
				
			</tr>
			     
		</table>
		<br>
	
	</div>
</body>
</html>