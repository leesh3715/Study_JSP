package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05
 */
@WebServlet("/score")
public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청과 응답에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// Ex05.jsp 요청 페이지에서 넘아온 파라미터 값 처리하기.
		String name = request.getParameter("name").trim();
		int kor = Integer.parseInt(request.getParameter("kor").trim());
		int eng = Integer.parseInt(request.getParameter("eng").trim());
		int mat = Integer.parseInt(request.getParameter("mat").trim());
		
		int tot = kor + eng + mat;
		float avg = tot / 3.0f;
		String avg1 = String.format("%.2f", avg);
		
		String grade = null;
		if(avg >= 90) {
			grade = "A학점";
		}else if(avg >= 80) {
			grade = "B학점";
		}else if(avg >= 70) {
			grade = "C학점";
		}else if(avg >= 60) {
			grade = "D학점";
		}else {
			grade = "F학점";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		
		out.println("<body>");
		out.println("<h2>" + name + "님의 성적표</h2>");
		out.println("이 름 : " + name + "<br>");
		out.println("국어점수 : " + kor + "점<br>");
		out.println("영어점수 : " + eng + "점<br>");
		out.println("수학점수 : " + mat + "점<br>");
		out.println("총 점 : " + tot + "점<br>");
		
		out.println("평 균 : " + avg1 + "점<br>");
		out.println("학 점 : " + grade + "<br>");
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
