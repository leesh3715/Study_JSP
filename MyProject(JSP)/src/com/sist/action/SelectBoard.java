package com.sist.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.sist.model.BoardDTO;
import com.sist.model.MangoDAO;

public class SelectBoard implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시판을 조회하는 메서드
		MangoDAO dao = new MangoDAO();
		ArrayList<BoardDTO> list = dao.selectBoard();
		request.setAttribute("List",list);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_list.jsp");
		return forward;
	}

}
