package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.BoardDTO;
import com.sist.model.MangoDAO;

public class ContBoard implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 클릭시 상세 내용 페이지
		int board_no = Integer.parseInt(request.getParameter("no"));
		
		MangoDAO dao = new MangoDAO();
		dao.boardHit(board_no); // 조회수 증가
		BoardDTO list =  dao.selectCont(board_no); // 상세 내역 조회
		
		request.setAttribute("Cont", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_cont.jsp?no=" + board_no);
		
		return forward;
	}

}
