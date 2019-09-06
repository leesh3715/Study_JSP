package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.BoardDAO;
import com.sist.model.BoardDTO;

@WebServlet("/select")
public class S_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public S_Board() {
        super();
 
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		ArrayList<BoardDTO> list = dao.getBoardList(); // 전체 리스트 조회하는 메서드 이름
		
		request.setAttribute("LIST", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("board_list.jsp"); //  이동 할 페이지 
		rd.forward(request, response);
		 
	}
}
