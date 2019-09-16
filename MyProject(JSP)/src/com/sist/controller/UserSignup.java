package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MangoDAO;
import com.sist.model.UserDTO;

@WebServlet("/usersignup")
public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSignup() {
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setPwd2(pwd2);
		dto.setName(name);
		
		MangoDAO dao = new MangoDAO();
		int result = dao.userSignup(dto);
		
		PrintWriter out = response.getWriter();

		if(result > 0) {
			
//			out.println("<script>");
//			out.println("alert('회원가입  성공')");
//			out.println("location.href='../index.jsp");
////			out.println("location.href='index.jsp?id="+id+"'");
//			out.println("</script>");
			response.sendRedirect("index.jsp");
		} else {
			out.println("<script>");
			out.println("alert('회원가입  실패')");
			out.println("location.href='../index.jsp");
//			out.println("location.href='index.jsp?id="+id+"'");
			out.println("</script>");
		}
}
}
