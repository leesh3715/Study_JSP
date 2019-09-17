package com.paging.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 상세 내용 페이지에서 글 삭제 
		int board_no = Integer.parseInt(request.getParameter("no"));
		//int nowPage = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = new BoardDAO();
		int res = dao.deleteBoard(board_no);
		
		PrintWriter out = response.getWriter();
		
		if (res > 0) {			
			System.out.println("삭제 성공");
			out.println("<script>");
			out.println("alert('게시글 삭제 성공')");
			out.println("location.href='select.do'");
			out.println("</script>");
		} else {
			System.out.println("삭제 실패");
			out.println("<script>");
			out.println("alert('게시글 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}

	}

}
