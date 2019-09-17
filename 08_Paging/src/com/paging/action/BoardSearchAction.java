package com.paging.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.paging.model.BoardDAO;
import com.paging.model.BoardDTO;



public class BoardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String find_field = request.getParameter("find_field").trim();
		String find_name =  request.getParameter("find_name").trim();
		
		//	페이징 처리
		int rowsize = 3; // 페이지당 보여질 게시물의 수
		int block = 3; // 아래 보여질 페이지 최대 수 - 예)[1][2][3] / [4][5][6]
		int totalRecord = 0; // DB상의 레코드 전체 게시글의 수
		int allPage = 0; // 전체 페이지 수
		
		int page = 0; 
		
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));  // board_list 페이지에서 page 값을 받아온다.
		} else {
			// 처음으로 리스트 페이지에 들어온 경우
			page = 1;
		}
		// 해당 페이지에서의 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		// 해당 페이지에서의 끝 번호
		int endNo = (page * rowsize);
		System.out.println(page);
		System.out.println(rowsize);
		// 해당 페이지의 시작 블럭
		int startBlock = (((page - 1) / block) * block) + 1;
		// 해당 페이지의 끝 블럭
		int endBlock = (((page - 1) / block) * block) + block;

		BoardDAO dao = new BoardDAO();
		System.out.println(find_field);
		System.out.println(find_name);
		totalRecord = dao.getListCountSearch(find_field, find_name); // 전체 게시글의 수를 저장해 줌
		System.out.println(totalRecord);
		// 전체 게시글의 수를 한 페이지당 보여질 게시물의 수로 나누어준다.
		// 이러한 작업을 거치면 전체 페이지가 나온다.
		// 전체 페이지가 나올 때 나머지가 있으면 무조건 올려주어야 한다.
	
		allPage = (int)(Math.ceil(totalRecord / (double)rowsize));  // ceil 함수는 나머지가 발생하면 자동으로 올림해주는 메서드
		
		if (endBlock > allPage) {
			endBlock = allPage;
		}

		ArrayList<BoardDTO> list = dao.searchBoard(find_field, find_name, page, rowsize);
		
		System.out.println(list.get(0).getBoard_regdate());
		System.out.println(list.get(0).getBoard_pwd());
		System.out.println(list.get(0).getBoard_hit());
		
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("List", list);
		request.setAttribute("find_field", find_field);
		request.setAttribute("find_name", find_name);
	}

}
