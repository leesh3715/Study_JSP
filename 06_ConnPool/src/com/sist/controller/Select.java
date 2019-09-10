package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Board1_DAO;
import com.sist.model.Board1_DTO;

@WebServlet("/select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Select() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB의 게시물 전체 리스트를 가져오는 메서드
		
		Board1_DAO dao = new Board1_DAO();
		ArrayList<Board1_DTO> list = dao.getList(); // 전체 리스트 가져오는 메서드
		
		// 키로 저장	
		request.setAttribute("LIST", list);
		
		// view page로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("board_list.jsp");
		rd.forward(request, response);
	}

}
