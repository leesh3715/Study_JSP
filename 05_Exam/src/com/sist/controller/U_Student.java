package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;

@WebServlet("/update")
public class U_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public U_Student() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		StudentDTO dto = new StudentDTO();
		dto.setHakbun(Integer.parseInt(request.getParameter("hakbun")));
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setTel(request.getParameter("tel"));
		dto.setMajor(request.getParameter("major"));
		dto.setGrade(Integer.parseInt(request.getParameter("grade")));
		
		StudentDAO dao = new StudentDAO();
		int result = dao.updateStudent(dto);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			response.sendRedirect("select");
		} else {
			out.println("<script>");
			out.println("alert('학생 수정에 실패 하였습니다.')");
			out.println("</script>");
			response.sendRedirect("select");
		}
	}

}
