package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;


@WebServlet("/delete")
public class D_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public D_Student() {
        super();
      
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		int hakbun = Integer.parseInt(request.getParameter("hakbun"));
		String pwd = request.getParameter("pwd");
		StudentDAO dao = new StudentDAO();
		int result = dao.deleteStudent(hakbun, pwd);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			response.sendRedirect("select");
		} else {
			out.println("<script>");
			out.println("alert('학생 삭제에 실패 하였습니다.')");
			out.println("</script>");
		}
	}

}
