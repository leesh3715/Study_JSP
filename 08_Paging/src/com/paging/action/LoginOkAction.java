package com.paging.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paging.controller.FrontController;
import com.paging.model.MemberDAO;
import com.paging.model.MemberDTO;

public class LoginOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 로그인 창에서 넘어온 파라미터 값을 가지고 회원인지 체크하는 컨트롤러
		String member_id = request.getParameter("id").trim();
		String member_pwd = request.getParameter("pwd").trim();
		MemberDAO dao = new MemberDAO();
		int res = dao.userCheck(member_id, member_pwd);
		// 서블릿에서 세션 객체를 생성해야 사용 할 수 있음
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (res > 0) { // 아이디와 비밀번호가 일치한 경우
			MemberDTO dto = dao.getMember(member_id);
			
			// 사용자의 정보를 세션 객체에 저장
			session.setAttribute("id", dto.getMember_id());
			session.setAttribute("name", dto.getMember_name());
			
			session.setAttribute("dto", dto);
			
			out.println("<script>");
			out.println("alert('로그인 성공 하였습니다.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
			
		} else if (res == -1) { // 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (res == -2) { // 회원 탈퇴 하거나, 회원이 아닌 경우
			out.println("<script>");
			out.println("alert('회원이 아닙니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('로그인에 실패 하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
}
