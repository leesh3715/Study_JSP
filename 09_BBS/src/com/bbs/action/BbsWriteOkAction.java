package com.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;


public class BbsWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 게시글 작성 폼페이지에서 넘어온 파라미터를 DB에 저장하는 컨트롤러
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("cont").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		BbsDTO dto = new BbsDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BbsDAO dao = new BbsDAO();
		int res = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		// 리턴된 결과를 가지고 해당 view page로 이동		
		if(res > 0) {
			forward.setRedirect(true); 
			forward.setPath("select.do");
			/*out.println("<script>");
			out.println("alert('게시글 추가 성공')");
			out.println("</script>");*/
		} else {
			forward.setRedirect(false);
			forward.setPath("board_write.jsp");
		}	
		return forward;
	}

}
