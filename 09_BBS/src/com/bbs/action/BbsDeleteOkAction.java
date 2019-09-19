package com.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;

public class BbsDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제를 눌렀을때 해당 하는 글을 삭제하는 메서드
		
		int board_no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		System.out.println(board_no);
		System.out.println(pwd);
		
		BbsDAO dao = new BbsDAO();
		int res = dao.deleteBoard(board_no,pwd);
		
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("select.do");
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
