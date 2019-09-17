package com.paging.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.BoardDAO;
import com.paging.model.BoardDTO;

public class BoardWriteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 입력 폼 창에서 넘어온 파라미터를 DB에 저장하는 컨트롤러
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("cont").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = new BoardDAO();
		int res = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if (res > 0) {
			System.out.println("추가 성공");
			out.println("<script>");
			out.println("alert('게시글 추가 성공')");
			out.println("location.href='select.do'");
			out.println("</script>");
		} else {
			System.out.println("추가 실패");
			out.println("<script>");
			out.println("alert('게시글 추가 실패')");
			out.println("history.back()");
			out.println("</script>");
		}

	}

}
