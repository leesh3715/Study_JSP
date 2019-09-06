package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.BoardDAO;
import com.sist.model.BoardDTO;

@WebServlet("/delete")
public class D_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public D_Board() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pwd = request.getParameter("pwd");
		
		// hidden 글 번호
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDAO dao = new BoardDAO();
		int res = dao.deleteBoard(pwd,board_no);
		
		
		PrintWriter out = response.getWriter(); // 웹 화면에 출력, 서블릿 
    	if(res > 0) { // delete문)이 성공한 경우
    		response.sendRedirect("select"); // https://doublesprogramming.tistory.com/63 redirect 참고
    		
    	} else if(res == -1) { // 게시글 번호가 없는 경우
    		out.println("<script>");
    		out.println("alert('게시글 번호가 없습니다.')");
    		out.println("history.back()"); // 이전페이지로 돌아가라
    		out.println("</script>");
    	} else if(res == -2) { //  비밀번호가 틀린 경우
    		out.println("<script>");
    		out.println("alert('비밀번호가 틀렸습니다.')");
    		out.println("history.back()"); 
    		out.println("</script>");
    	} else{
    		out.println("<script>");
    		out.println("alert('레코드 삭제 실패했습니다.')");
    		out.println("history.back()"); 
    		out.println("</script>");
    	}
	}

}
