package com.paging.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.BoardDAO;
import com.paging.model.BoardDTO;

public class BoardContAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글 제목을 클릭 시 상세 내용을 보여주는 컨트롤러
		int board_no = Integer.parseInt(request.getParameter("no"));
		int nowPage = Integer.parseInt(request.getParameter("page"));

		BoardDAO dao = new BoardDAO();
		dao.boardHit(board_no); // 조회수 증가 메서드 호출
		BoardDTO dto = dao.boardCont(board_no); // 게시글 상세 내역 조회 메서드 호출
		
		request.setAttribute("cont", dto);
		request.setAttribute("page", nowPage);
	}

}
