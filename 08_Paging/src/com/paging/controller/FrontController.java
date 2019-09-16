package com.paging.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.action.Action;
import com.paging.action.BoardListAction;

public class FrontController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 페이지가 이 쪽으로 들어오기 때문에  한글 인코딩 처리가 됨
		// 서블릿 매핑을 통해서 프론트 컨트롤러로 다 들어옴
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html; charset=UTF-8");
		
		//getRequestURI(): 현재 프로젝트 명과 파일명을 반환하는 메서드
		//"/프로젝트명/파일명(*.do)" 문자열을 반환하는 메서드
		String uri = request.getRequestURI(); // "/08_Paging/select.do"
		System.out.println("uri ==> " + uri);
		// getContextPath(): 편재 프로젝트명을 반환하는 메서드
		String path = request.getContextPath(); // "/08_Paging"
		System.out.println("path ==> " + path);
		String command = uri.substring(path.length() + 1); // 인자 값이 하나면 매개변수부터 끝까지
		System.out.println("command ==> " + command);
//////////////////////////////////////////////////////////////////////////////////////////////////
		Action action = null;
		String viewPage = null;
		if(command.equals("select.do")){  // select문을 받았을 때
			action = new BoardListAction();
			action.excute(request, response);  // select 조회문이 들어있는 클래스의 메서드를 호출
			viewPage ="board_list.jsp";
		}
		// 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
