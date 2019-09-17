package com.paging.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.BoardDAO;
import com.paging.model.BoardDTO;

public class BoardEditOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("cont").trim();
		String board_pwd = request.getParameter("pwd").trim();
		System.out.println(board_title);
		int board_no = Integer.parseInt(request.getParameter("no"));
		//request.getParameter("page");
		System.out.println(board_no);
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = new BoardDAO();
		int res = dao.editboard(board_no, dto);
		PrintWriter out = response.getWriter();
		
		if (res > 0) {			
			System.out.println("수정 성공");
			out.println("<script>");
			out.println("alert('게시글 수정 성공')");
			out.println("location.href='select.do'");
			out.println("</script>");
		} else if (res < 0) {
			System.out.println("비밀번호가 다름! 수정 실패");
			out.println("<script>");
			out.println("alert('비밀번호 다름, 게시글 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			System.out.println("수정 실패");
			out.println("<script>");
			out.println("alert('게시글 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
