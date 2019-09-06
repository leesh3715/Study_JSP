package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

/**
 * Servlet implementation class Update_Controller
 */
@WebServlet("/update.do")
public class Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Controller() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	// 폼 창에서 넘어온 파라미터 값을 처리해 주자
    	String id = request.getParameter("id").trim();
    	String pwd = request.getParameter("pwd").trim();
    	String rename = request.getParameter("name").trim();
    	
    	//DTO 객체에 저장하여 DB로 전송
    	MemberDTO dto = new MemberDTO();
    	dto.setId(id);
    	dto.setPwd(pwd);
    	dto.setName(rename);
    	
    	MemberDAO dao = new MemberDAO();
    	int res = dao.update(dto); // res 값이 3개 중 하나 넘어옴
    	
    	PrintWriter out = response.getWriter(); // 웹 화면에 출력, 서블릿 
    	if(res > 0) { // update문(수정)이 성공한 경우
    		response.sendRedirect("select.do"); // https://doublesprogramming.tistory.com/63 redirect 참고
    		
    	} else if(res == -1) {  // 비밀번호가 틀린 경우
    		out.println("<script>");
    		out.println("alert('비밀번호가 틀렸습니다. 다시 한번 확인 요망')");
    		out.println("history.back()"); // 이전페이지로 돌아가라
    		out.println("</script>");
    	} else if(res == -2) { //  아이디가 없는 경우
    		out.println("<script>");
    		out.println("alert('아이디가 없습니다. 회원가입을 진행하세요')");
    		out.println("history.back()"); 
    		out.println("</script>");
    	} else{
    		out.println("<script>");
    		out.println("alert('레코드 수정이 실패했습니다.')");
    		out.println("history.back()"); 
    		out.println("</script>");
    	}
	}
}
