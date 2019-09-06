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

@WebServlet("/insert")
public class I_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public I_Board() {
       super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charse=UTF-8");
		
		// 게시물 입력창에서 넘어온 파라미터 값을 처리 해주자.
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		// BoardDTO 객체에 setter() 메서드를 이용하여 데이터를 저장하자.
		BoardDTO dto = new BoardDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = new BoardDAO();
		int res = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res>0) { // 정상적으로 레코드 삽입이 성공한 경우
			response.sendRedirect("select");
		} else{ // 게시글 추가 실패한 경우
			out.println("<script>");
			out.println("alert('게시물 저장에 실패하였습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
	}

}
