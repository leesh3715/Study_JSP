package com.bbs.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// DB의 전체 레코드를 조회하는 컨트롤러
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsDTO> list =  dao.getBbsList();
		
		request.setAttribute("List", list);
		
		// view 페이지로 포워딩
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_list.jsp");
		
		return forward;
	}

}
