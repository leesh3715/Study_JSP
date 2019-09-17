<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
      <hr width="50%" color="red">
      <h3>MVC2 모델 게시판 글쓰기</h3>
      <hr width="50%" color="red">

      <form action="<%=request.getContextPath()%>/write_ok.do"
         method="post">
         <table border="1" width="400" cellspacing="0">
            <tr>
               <th>작성자</th>
               <td><input name="writer"></td>
            </tr>
            <tr>
               <th>글제목</th>
               <td><input name="title"></td>
            </tr>
            <tr>
               <th>글내용</th>
               <td><textarea rows="8" cols="30" name="cont"></textarea></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
               <input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp; 
                  <input type="reset" value="취소"></td>
            </tr>
         </table>
      </form>
   </div>
</body>
</html>