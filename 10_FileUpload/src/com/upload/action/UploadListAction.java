package com.upload.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// upload 테이블에 있는 전체 리스트를 조회하는 컨트롤러
		
		UploadDAO dao = new UploadDAO();
		ArrayList<UploadDTO> list =  dao.uploadList();
		
		request.setAttribute("uploadList", list);

	}

}
