package com.upload.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.action.Action;
import com.upload.action.UploadContAction;
import com.upload.action.UploadListAction;
import com.upload.action.UploadWriteOkAction;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 현재 프로젝트 명+파일명(*.do)를 문자열로 반환하는 메서드 
		String uri = request.getRequestURI();
		// 현재 프로젝트 명을 문자열로 반환하는 메서드
		String path = request.getContextPath();
		String command = uri.substring(path.length()+1); // 파일명만 반환
		System.out.println(command);
		
		Action action = null;
		String viewPage = null;
		
		if(command.equals("upload_list.do")) {
			action = new UploadListAction();
			action.execute(request, response);
			viewPage = "upload_list.jsp";
		} else if(command.equals("upload_write.do")){
			viewPage = "upload_write.jsp";
		} else if(command.equals("upload_write_ok.do")){
			action = new UploadWriteOkAction();
			action.execute(request, response);
		} else if(command.equals("upload_cont.do")){
			action = new UploadContAction();
			action.execute(request, response);
			viewPage = "upload_cont.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
