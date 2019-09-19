package com.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 게시글 수정 폼페이지에서 넘어온 파라미터를 DB에 저장하는 컨트롤러
		int board_no = Integer.parseInt(request.getParameter("no"));
		String board_writer = request.getParameter("writer");
		String board_title = request.getParameter("title");
		String board_cont = request.getParameter("cont");
		String board_pwd = request.getParameter("pwd");
				
		BbsDTO dto = new BbsDTO();
		
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BbsDAO dao = new BbsDAO();
		int res = dao.editBoard(dto,board_no);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
	
		if(res > 0) {
			forward.setRedirect(true); 
			forward.setPath("select.do");
		} else{
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
