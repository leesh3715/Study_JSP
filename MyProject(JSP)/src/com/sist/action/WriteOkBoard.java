package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.BoardDTO;
import com.sist.model.MangoDAO;

public class WriteOkBoard implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시판 글쓰기
		System.out.println("OKstart");
		String board_writer = request.getParameter("writer");
		String board_title = request.getParameter("title");
		String board_cont = request.getParameter("cont");
		String board_pwd = request.getParameter("pwd");
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		MangoDAO dao = new MangoDAO();
		int res =  dao.insertBoard(dto);
		ActionForward forward = new ActionForward();
		
		if (res > 0) {
			forward.setRedirect(true);
			forward.setPath("select.do");
		} else {
			forward.setRedirect(false);
			forward.setPath("board_write.jsp");
		}
		return forward;
	}

}
