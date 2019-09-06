package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex04
 */
@WebServlet("/hobby")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex04() {
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
		
		// Ex04.jsp 페이지에서 넘어온 파라미터 값을 처리해 주자.
		String[] hob = request.getParameterValues("hobby");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>나의 취미</h2>");
		/*for(int i=0; i<hob.length; i++) {
			out.println(hob[i]+"&nbsp;&nbsp;&nbsp;");
		}*/
		for(String h : hob) {
			out.println(h+"&nbsp;&nbsp;&nbsp;");
		}
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
