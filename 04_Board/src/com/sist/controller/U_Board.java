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

@WebServlet("/update")
public class U_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public U_Board() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 수정 폼 창에서 넘어오는 파라미터를 처리해 보자.
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		// 수정 폼 창에서 hidden 으로 넘어온 데이터도 처리해주어야 한다.
		int board_no = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_no(board_no);
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = new BoardDAO();
		int res = dao.updateBoard(dto);
		
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.println("<script>");
			out.println("alert('게시물 수정 성공')");
			out.println("location.href='board_cont.jsp?no="+board_no+"'");
			out.println("</script>");
		} else if (res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (res == -2) {
			out.println("<script>");
			out.println("alert('없는 게시글 번호 입니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		else{
			out.println("<script>");
			out.println("alert('게시물 수정에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		}
	}

}
