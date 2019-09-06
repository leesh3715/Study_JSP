package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03
 */
@WebServlet("/adder1")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		
		// Ex03.jsp 페이지에서 넘어온 데이터를 처리해 주자.
		// trim() : 입력폼 창의 데이터 중에 맨 앞과 맨 뒤의 공백을 제거하는 메서드.
		int su1 = Integer.parseInt(request.getParameter("num1").trim());
		int su2 = Integer.parseInt(request.getParameter("num2").trim());
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>두 수의 합은 ==> " + (su1+su2) + "</h2>");
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
