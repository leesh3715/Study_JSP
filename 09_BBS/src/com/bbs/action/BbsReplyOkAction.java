package com.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsDAO;
import com.bbs.model.BbsDTO;

public class BbsReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 답변글 폼에서 넘어온 파라미터를 DB에 저장하여 처리하는 컨트롤러 
		
		String reply_writer =  request.getParameter("writer").trim();
		String reply_title =  request.getParameter("title").trim();
		String reply_cont =  request.getParameter("cont").trim();
		String reply_pwd =  request.getParameter("pwd").trim();
		
		// 히든으로 넘어온 데이터도 처리해 주자
		int board_no = Integer.parseInt(request.getParameter("board_no").trim());
		int board_group = Integer.parseInt(request.getParameter("board_group").trim());
		int board_step = Integer.parseInt(request.getParameter("board_step").trim());
		int board_indent = Integer.parseInt(request.getParameter("board_indent").trim());
		
		BbsDTO dto = new BbsDTO();
		dto.setBoard_no(board_no);
		dto.setBoard_writer(reply_writer);
		dto.setBoard_title(reply_title);
		dto.setBoard_cont(reply_cont);
		dto.setBoard_pwd(reply_pwd);
		dto.setBoard_group(board_group);
		dto.setBoard_step(board_step);
		dto.setBoard_indent(board_indent);
		
		System.out.println(board_step);
		
		BbsDAO dao = new BbsDAO();
		dao.replyUpdate(board_group, board_step);
		int res = dao.replyBoard(dto);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) { // 답변 글이 정상적으로 DB에 저장 된 경우
			forward.setRedirect(true);
			forward.setPath("select.do");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글 답변 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}
}
