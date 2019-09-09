package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;


@WebServlet("/select")
public class S_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public S_Student() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentDTO> list = dao.selectStudent();
		
		request.setAttribute("LIST", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_list.jsp");
		rd.forward(request, response);
	}

}
