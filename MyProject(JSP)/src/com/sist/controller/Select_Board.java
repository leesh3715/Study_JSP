package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.BoardDTO;
import com.sist.model.MangoDAO;


@WebServlet("/select_board")
public class Select_Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Select_Board() {
        super();
      
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MangoDAO dao = new MangoDAO();
		ArrayList<BoardDTO> list = dao.selectBoard(); // 전체 리스트 조회하는 메서드 이름
		
		request.setAttribute("LIST", list);
		System.out.println("데이터 가져왔음");
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp"); //  이동 할 페이지 
		rd.forward(request, response);
	}

}
