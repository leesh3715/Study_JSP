package com.paging.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import com.paging.action.*;


public class FrontController extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      //한글 인코딩 처리
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
   
      //getRequestURI() : 현재 프로젝트명과 파일명을 반환하는 메서드.
      // "/프로젝트명/파일명(*.do)"문자열을 반환하는 메서드.
 
      String uri = request.getRequestURI(); // "/08_Paging/select.do"
      System.out.println("uri ==> "+uri);
      
      // getContextPath() : 현재 프로젝트명을 문자열로 반환하는 메서드.
      String path = request.getContextPath();// "/08_Paging"
      System.out.println("path==>"+path);
      
      String command = uri.substring(path.length()+1);
      System.out.println("command==>"+command);
      
		Action action = null;
		String viewPage = null;
		
      if(command.equals("select.do")) {
         action = new BoardListAction();
         action.execute(request, response);
         viewPage="board_list.jsp";
      }else if(command.equals("write.do")) {
         viewPage = "board_write.jsp";
         
      } else if(command.equals("write_ok.do")){
         action  = new BoardWriteOkAction();
         action.execute(request, response);
         
      } else if(command.equals("cont.do")) {
         action = new BoardContAction();
         action.execute(request, response);
         viewPage = "board_cont.jsp";
         
      } else if(command.equals("delete.do")){
    	  action = new BoardDeleteAction();
    	  action.execute(request, response);
    	  
      } else if(command.equals("edit.do")){
    	  action = new BoardContAction(); // 글을 불러오기 위해서 여기서도 호출
          action.execute(request, response);
          viewPage = "board_edit.jsp";
          
      } else if(command.equals("edit_ok.do")){
    	  action  = new BoardEditOkAction();
          action.execute(request, response);
         
      } else if(command.equals("search.do")){
    	  action = new BoardSearchAction();
    	  action.execute(request, response);
          viewPage="board_search.jsp";
   ////////////////////////////////// 190918 start
      } else if(command.equals("join.do")){
    	  viewPage = "board_join.jsp";
    	  
      } else if(command.equals("zipcode_find.do")){
    	  viewPage = "zipcode.jsp";
      } else if(command.equals("zipcode_ok.do")){
    	  action = new ZipcodeAction();
    	  action.execute(request, response);
    	  viewPage = "zipcode.jsp";
      } else if(command.equals("join_ok.do")){
    	  action = new JoinOkAction();
    	  action.execute(request, response);
      } else if(command.equals("login.do")){
    	  viewPage = "login.jsp";
      } else if(command.equals("login_ok.do")){
    	  action = new LoginOkAction();
    	  action.execute(request, response);
      } else if(command.equals("logout.do")){
    	  viewPage = "logout.jsp";
      }
      
      //페이지 이동
      if(viewPage!=null) {
      RequestDispatcher rd = request.getRequestDispatcher(viewPage);
      rd.forward(request, response);
      }
   }
}