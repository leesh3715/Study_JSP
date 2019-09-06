package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex02
 */
@WebServlet("/profile")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청과 응답에 관한 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// Ex02.jsp 페이지에서 요청한 데이터를 받아주기.
		// getParameter() : 일반적으로 하나의 파라미터 값만을 받을 때 사용하는 메서드.
		// getParameterValues() : 배열 형식의 파라미터 값을 받을 때 사용하는 메서드.
		// getParameterMap() : 맵 형식의 파라미터 값을 받을 때 사용하는 메서드.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// HTML 웹 페이지로 출력해 보자.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>");
		out.println("이 름 : " + name + "<br>");
		out.println("나 이 : " + age + "<br>");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
