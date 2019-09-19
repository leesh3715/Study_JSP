package com.bbs.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsContAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 글 번호가 넘어온 글 번호를 대상으로 상세 내역을 조회하는 컨트롤러
		int board_no = Integer.parseInt(request.getParameter("no"));
		
		BbsDAO dao = new BbsDAO();
		dao.boardHit(board_no); // 조회수 증가 메서드
		BbsDTO dto =  dao.getCont(board_no);
		
		//키로 저장
		request.setAttribute("cont", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_cont.jsp");
		
		return forward;
	}

}
