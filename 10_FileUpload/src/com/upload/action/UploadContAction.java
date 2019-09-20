package com.upload.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadContAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 글 번호에 해당하는 상세내역을 확인하는 컨트롤러
		int upload_no = Integer.parseInt(request.getParameter("no"));
		
		UploadDAO dao = new UploadDAO();
		dao.uploadHit(upload_no);
		UploadDTO dto = dao.uploadCont(upload_no);
		
		request.setAttribute("uploadCont", dto);

	}

}
