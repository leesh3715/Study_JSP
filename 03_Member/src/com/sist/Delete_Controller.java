package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;

@WebServlet("/delete.do")
public class Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Delete_Controller() {
        super();
    
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		//삭제 폼 창에서 넘어온 파라미터 값을 처리해보자.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DTO 객체에 담아서 넘기지 말고 바로 인자로 받아서 DAO의 delete 메서드 실행
		MemberDAO dao = new MemberDAO();
		int res = dao.delete(id,pwd); //
		
		PrintWriter out = response.getWriter(); // 웹 화면에 출력, 서블릿 
    	if(res > 0) { // delete문(수정)이 성공한 경우
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
    		out.println("alert('레코드 삭제 실패했습니다.')");
    		out.println("history.back()"); 
    		out.println("</script>");
    	}
	}
	

}
