package com.sist;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

@WebServlet("/insert.do")
public class Insert_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Insert_Controller() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 한글 인코딩
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	// 폼 창에서 넘어온 파라미터 값을 처리해 주자
    	String id = request.getParameter("id").trim();
    	String pwd = request.getParameter("pwd").trim();
    	String name = request.getParameter("name").trim();
    	// DTO 객체 생성
    	MemberDTO dto = new MemberDTO();
    	dto.setId(id);
    	dto.setPwd(pwd);
    	dto.setName(name);
    	
    	// 실제 DB에 레코드 저장
    	MemberDAO dao = new MemberDAO(); // 객체 생성과 바로 DB연결
    	int res = dao.insert(dto); // 인자 값으로 dto 객체를 넘겨줌(id,pwd,name)을 가진 객체, 정상적으로 들어 갔으면 1이 들어감
    	request.setAttribute("Result", res);
    	// 페이지 이동
    	RequestDispatcher rd = request.getRequestDispatcher("insertPro.jsp");
    	rd.forward(request, response); // 값이 넘어감
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
