package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06
 */
@WebServlet("/join")
public class Ex06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청, 응답 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// Ex06.jsp 페이지에서 넘어온 파라미터 값을 처리해 보자.
		String userId = request.getParameter("id").trim();
		String userPwd = request.getParameter("pwd").trim();
		String user_name = request.getParameter("name").trim();
		String gender = request.getParameter("gender").trim();
		String[] hob = request.getParameterValues("hobby");
		String email = request.getParameter("email").trim();
		String addr = request.getParameter("addr").trim();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>회 원 정 보</h2>");
		out.println("<h3>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + userPwd + "<br>");
		out.println("이 름 : " + user_name + "<br>");
		out.println("성 별 : " + gender + "<br>");
		out.println("취 미 : ");
		
		for(String h : hob) {
			out.println(h + "&nbsp;&nbsp;&nbsp;");
		}
		out.println("<br>");
		out.println("이메일 : " + email + "<br>");
		out.println("거주지 : " + addr + "<br>");
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
