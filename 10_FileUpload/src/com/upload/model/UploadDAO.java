package com.upload.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UploadDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;	
	
	public UploadDAO() {
		try {
			// Context를 사용해도 됨 상위
			// 1. JNDI 서버 객체 생성
			InitialContext ic = new InitialContext();
			// 2. lookup 메서드를 이용하여 DBCP 자원을 찾는다. 
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			// 3. 커넥션 풀에서 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 생성자 end
	
	// upload 테이블에서 전체 리스트를 조회하는 메서드
	public ArrayList<UploadDTO> uploadList(){
		ArrayList<UploadDTO> list = new ArrayList<UploadDTO>();
		try {
			sql = "select * from upload order by upload_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				UploadDTO dto = new UploadDTO();
				dto.setUpload_no(rs.getInt("upload_no"));
				dto.setUpload_writer(rs.getString("upload_writer"));
				dto.setUpload_title(rs.getString("upload_title"));
				dto.setUpload_cont(rs.getString("upload_cont"));
				dto.setUpload_pwd(rs.getString("upload_pwd"));
				dto.setUpload_file(rs.getString("upload_file"));
				dto.setUpload_hit(rs.getInt("upload_hit"));
				dto.setUpload_date(rs.getString("upload_date"));
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//글 쓰기
	public int insertUpload(UploadDTO dto){
		int result = 0;
		
		try {
			sql = "insert into upload values(upload_seq.nextval,?,?,?,?,?,default,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUpload_writer());
			pstmt.setString(2, dto.getUpload_title());
			pstmt.setString(3, dto.getUpload_cont());
			pstmt.setString(4, dto.getUpload_pwd());
			pstmt.setString(5, dto.getUpload_file());
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void uploadHit(int upload_no){
		try {
			sql = "update upload set upload_hit = upload_hit + 1 where upload_hit = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, upload_no);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// upload 테이블의 글 번호에 해당하는 상세 내역을 조회하는 메서드
	public UploadDTO uploadCont(int board_no){
		UploadDTO dto = new UploadDTO();
		try {
			sql = "select * from upload where upload_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setUpload_no(rs.getInt("upload_no"));
				dto.setUpload_writer(rs.getString("upload_writer"));
				dto.setUpload_title(rs.getString("upload_title"));
				dto.setUpload_cont(rs.getString("upload_cont"));
				dto.setUpload_pwd(rs.getString("upload_pwd"));
				dto.setUpload_file(rs.getString("upload_file"));
				dto.setUpload_hit(rs.getInt("upload_hit"));
				dto.setUpload_date(rs.getString("upload_date"));
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
