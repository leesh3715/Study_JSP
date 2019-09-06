package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex01() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 응답 시 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		
		// HTML 문서로 출력하기
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>doGet() 메서드를 호출 하였습니다.</h2>");		
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
