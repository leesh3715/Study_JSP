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

@WebServlet("/search")
public class S2_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public S2_Student() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String field_find = request.getParameter("field_find");
		String field_name = request.getParameter("field_name");
		
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentDTO> list = dao.searchStudent(field_find, field_name);
		
		request.setAttribute("Search", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_search.jsp");
		rd.forward(request, response);
		 
	}

}
