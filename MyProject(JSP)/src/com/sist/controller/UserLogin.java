package com.sist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userlogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; setchar=UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	}

}
