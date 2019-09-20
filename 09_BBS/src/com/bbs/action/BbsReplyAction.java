package com.bbs.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 답변글 폼에 넘겨줄 상세 내용을 조회하는 컨트롤러
		int board_no = Integer.parseInt(request.getParameter("no"));
		
		BbsDAO dao = new BbsDAO();
		BbsDTO dto =  dao.getCont(board_no); // 해당하는 글 번호에 대한 글 내용을 출력하는 메서드
		
		request.setAttribute("reply", dto); 
		
		//view 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_reply.jsp");
		return forward;
	}

}
