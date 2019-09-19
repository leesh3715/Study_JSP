package com.bbs.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.Parent;

public class BbsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_no = Integer.parseInt(request.getParameter("no"));
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board_delete.jsp?no="+board_no);
		return forward;
	}

}
