package com.paging.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.MemberDAO;
import com.paging.model.MemberDTO;

public class JoinOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 회원가입 폼 창에서 넘어온 파라미터 들을 DB에 젖아하는 컨트롤러
		String member_id = request.getParameter("member_id").trim();
		String member_pass = request.getParameter("member_pass").trim();
		String member_name = request.getParameter("member_name").trim();
		String member_nickname = request.getParameter("member_nickname").trim();
		String member_zip1 = request.getParameter("member_zip1").trim();
		String member_zip2 = request.getParameter("member_zip2").trim();
		String member_addr1 = request.getParameter("member_addr1").trim();
		String member_addr2 = request.getParameter("member_addr2").trim();

		MemberDTO dto = new MemberDTO();
		dto.setMember_id(member_id);
		dto.setMember_pwd(member_pass);
		dto.setMember_name(member_name);
		dto.setMember_nickname(member_nickname);
		dto.setMember_zip1(member_zip1);
		dto.setMember_zip2(member_zip2);
		dto.setMember_addr1(member_addr1);
		dto.setMember_addr2(member_addr2);
		MemberDAO dao = new MemberDAO();
		int res = dao.insertMember(dto);
		
		PrintWriter out = response.getWriter();
		if(res>0) {
			out.println("<script>");
			out.println("alert('회원가입 성공')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else {
			
		}
	}

}
