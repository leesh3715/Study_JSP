package com.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadWriteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 자료실 폼에서 넘어온 파라미터를 DB에 저장하는 컨트롤러
		
		UploadDTO dto = new UploadDTO();
		
		// 첨부파일이 저장될 위치
		String saveFolder = "C:\\Users\\SIST073\\workspace(jsp)\\10_FileUpload\\WebContent\\upload";
		// 첨부파일의 최대 크기
		int fileSize = 10 * 1024 * 1024; // 기본 단위는 kb = 10MB
		
		// 파일 업로드 진행 시 이진파일 업로드를 위한 객체 생성
		// request: 일반적인 request
		// savaFolder:  업로드 파일 저장 위치
		// fileSize: 업로드할 파일의 최대 크기
		// 문자 인코딩 방식
		//  new DefaultFileRenamePolicy() // 파일 이름 중복이 안되게 설정해주는 생성자
		//MultipartRequest test = new MultipartRequest(request, saveDirectory, maxPostSize, policy)
		MultipartRequest multi = new MultipartRequest(request, saveFolder, fileSize,"UTF-8", new DefaultFileRenamePolicy());
		
		// 자료실 폼에서 넘어온 파라미터를 처리해주자
		// 파일 업로드 시 request 말고 multi를 사용
		String upload_writer = multi.getParameter("writer");
		String upload_title = multi.getParameter("title");
		String upload_cont = multi.getParameter("cont");
		String upload_pwd = multi.getParameter("pwd");

		// 입력 폼 창에서 type="file"이라고 되어 있으면, getFile() 메서드로 받아야 함
		File upload_file = multi.getFile("file");
		
		if(upload_file!=null) { // 첨부파일이 있는 경우
			// getName() : 첨부파일의 이름을 문자열로 반환하는 메서드
			String fileName = upload_file.getName();
			// 날짜 객체 생성
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			// .../upload/2019-09-20 폴더 생성
			String homedir = saveFolder + "/" + year + "-" + month + "-" + day;
			File path1 = new File(homedir);
			if(!path1.exists()){ // 이 폴더가 없다면
				path1.mkdirs(); // 실제 폴더가 만들어짐
			}
			// 파일을 만들어보자
			String refileName = upload_writer + "_" + fileName;
			upload_file.renameTo(new File(homedir + "/" + refileName));
			String fileDBName = "/" + year + "-" + month + "-" + day + "/" + refileName;
			
			dto.setUpload_file(fileDBName);
		}
		
		dto.setUpload_writer(upload_writer);
		dto.setUpload_title(upload_title);
		dto.setUpload_cont(upload_cont);
		dto.setUpload_pwd(upload_pwd);
		
		UploadDAO dao = new UploadDAO();
		int res = dao.insertUpload(dto);
		PrintWriter out = response.getWriter();
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 업로드 성공')");
			out.println("location.href='upload_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시물 업로드 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
