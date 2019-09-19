package com.bbs.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.action.Action;
import com.bbs.action.ActionForward;

public class FrontController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 현재 프로젝트명과 파일명을 반환하는 메서드
		//"/09_BBS(프로젝트명)/*.do(파일명)" 문자열로 반환한다
		String uri = request.getRequestURI();

		// 현재 프로젝트 명을 반환하는 메서드
		// "/09_BBS(프로젝트명)" 문자열로 반환한다.
		String path = request.getContextPath();
		
		String command = uri.substring(path.length()+1); // 결과값이 "*.do"
		
		Action action = null;
		ActionForward forward = null;
		/*
		 * java.util.Properties 클래스
		 * Properties 클래스는 HashTable의 하위 클래스.
		 * 보통은 환경변수 및 속성 값을 Properties 파일에 저장하여 쉽게 접근 할 수 있는 장점이 있음.
		 * Properties 파일은 일련의 키-값의 쌍으로 이루어지며, 보통은 파일에 저장하여 사용 됨
		 * 파일 이름을 *.properties로 끝나게 됨
		 * InputStream 에 Properties 파일을 넣어서 그 스트림으로부터 파일을 가져온다.
		 * 인자로 들어온 Properties 파일을 읽어 들인다.
		 * 읽어들일때 사용하는 메서드가 load() 메서드를 이용한다.
		 * FileInputStream 객체는 사용 후 반드시 닫아주어야 한다.
		 * */
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\SIST073\\workspace(jsp)\\09_BBS\\src\\com\\bbs\\controller\\mapping.properties");
		prop.load(fis);
		fis.close();
		String value = prop.getProperty(command); // *.do
		System.out.println(command);
		System.out.println(value);
		
		if(value.substring(0,7).equals("execute")){
			try {
				StringTokenizer st = new StringTokenizer(value,"|"); // value 값을 |로 구분해서 잘라준다.
				String url_1 = st.nextToken(); // execute
				String url_2 = st.nextToken(); // 패키지명.클래스명
/*	
 * 				Class.forName(className)은 파라미터로 받은 className에
 * 				해당 하는 클래스를 로딩한 후에, 그 클래스에 해당하는 Class 인스턴스를 리턴한다.			
 * 				newInstance() 메서드는 로딩한 클래스의 객체를 생성하는 메서드이고, 이렇게 생성되는 객체를 동적 클래스 로딩이라고 한다. */
				Class url = Class.forName(url_2); //  url_2에 저장되어있는 클래스명의 클래스를 로딩
				action = (Action)url.newInstance(); // 객체를 생성해주는 메서드
				forward = action.execute(request, response); // forward 객체에 다시 저장 리턴이 ActionForward 타입
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{ //  value의 값 중에 execute가 아닌 경우
			// 액션으로 넘어가는 경우와 아닌 경우
			// 바로 view page로 이동
			forward = new ActionForward();
			forward.setRedirect(false); // *.jsp 페이지로 이동
			forward.setPath(value);
		}
		
		if(forward != null) {
			if(forward.isRedirect()){ // true, *.do 인 경우
				response.sendRedirect(forward.getPath());
			} else { // false, *.jsp인 경우
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}
