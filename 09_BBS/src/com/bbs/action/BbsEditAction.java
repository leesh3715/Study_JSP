package com.bbs.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// DB에서 값을 불러와 수정 하는 메서드
		// get 방식으로 글 번호가 넘어온 글 번호를 대상으로 상세 내역을 조회하는 컨트롤러
				int board_no = Integer.parseInt(request.getParameter("no"));
				
				BbsDAO dao = new BbsDAO();
				BbsDTO dto =  dao.getCont(board_no);
				
				//키로 저장
				request.setAttribute("cont", dto);
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("board_edit.jsp");
				
				return forward;
	}

}
