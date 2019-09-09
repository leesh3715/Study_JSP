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

/**
 * search 서블릿
 */
@WebServlet("/search")
public class S1_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public S1_Board() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String find_field = request.getParameter("find_field").trim();
		String find_name =  request.getParameter("find_name").trim();
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.searchBoard(find_field, find_name);
		 
		request.setAttribute("Search", list);
		RequestDispatcher rd = request.getRequestDispatcher("board_search.jsp");
		rd.forward(request, response);
	}

}
