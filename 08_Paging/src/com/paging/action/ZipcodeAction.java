package com.paging.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.MemberDAO;

public class ZipcodeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 사용자가 입력한 동을 대상으로 테이블 조회하는 컨트롤러
		String dong = request.getParameter("dong").trim();
		MemberDAO dao = new MemberDAO();
		ArrayList ziplist = dao.searchZipcode(dong);
		request.setAttribute("zip", ziplist);
		request.setAttribute("dong", dong);
	}

}
