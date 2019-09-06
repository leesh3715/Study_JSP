package com.sist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

/**
 * Servlet implementation class Select_Controller
 */
@WebServlet("/select.do")
public class Select_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Select_Controller() {
        super();   
    }
    // GET, POST 둘다 처리하는 메서드
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MemberDAO dao = new MemberDAO(); // con 객체 생성
    	ArrayList<MemberDTO> list = dao.select(); // dao.select() 의 반환형은 ArrayList 형
    	request.setAttribute("List", list);
    	// 페이지 이동
    	RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
    	rd.forward(request, response); // 실제로 이동은 여기서 실행
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
