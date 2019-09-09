package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class StudentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	
	public StudentDAO() { // 기본 생성자
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1111";
		
		// 1. 드라이버 로딩
		try {
			Class.forName(driver);
		// 2. DB연결
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	// 학생 전체 리스트를 조회하는 메서드
	public ArrayList<StudentDTO> selectStudent(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

		try {
			sql = "select * from student1";
			 pstmt = con.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while(rs.next()){
				 StudentDTO dto = new StudentDTO();
				 dto.setHakbun(rs.getInt("hakbun"));
				 dto.setName(rs.getString("name"));
				 dto.setId(rs.getString("id"));
				 dto.setPwd(rs.getString("pwd"));
				 list.add(dto);
			 }
			 // open 객체 닫기
			 rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertStudent(StudentDTO dto){
		int result = 0;
		
		try {
			sql = "insert into student1 values(student1_seq.nextval,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getMajor());
			pstmt.setInt(6, dto.getGrade());
			result = pstmt.executeUpdate();
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 상세 정보 출력
	public StudentDTO studentCont(int hakbun) {
		StudentDTO dto = new StudentDTO();
		
		try {
			sql = "select * from student1 where hakbun = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			rs = pstmt.executeQuery();
			while(rs.next()){ 
				dto.setHakbun(rs.getInt("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setTel(rs.getString("tel"));
				dto.setMajor(rs.getString("major"));
				dto.setGrade(rs.getInt("grade"));
				dto.setReg_date(rs.getString("reg_date"));
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int updateStudent(StudentDTO dto) {
		int result = 0;
		try {
			sql="update student1 set name = ?, id = ?, pwd = ?, tel = ?, major = ?, grade =? where hakbun = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getMajor());
			pstmt.setInt(6, dto.getGrade());
			pstmt.setInt(7, dto.getHakbun());
			result = pstmt.executeUpdate();
			
			System.out.println(dto.getName());
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getHakbun());
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return result;
	}
	
	public int deleteStudent(int hakbun, String pwd) {
		int result = 0;
		
		try {
			sql = "delete from student1 where hakbun = ? and pwd =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			pstmt.setString(2, pwd);
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<StudentDTO> searchStudent(String field_find, String field_name){
		ArrayList<StudentDTO> list = new ArrayList<>();
		
		if(field_find.equals("1")) {
			try {
				sql = "select * from student1 where id like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+field_name+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 StudentDTO dto = new StudentDTO();
					 dto.setHakbun(rs.getInt("hakbun"));
					 dto.setName(rs.getString("name"));
					 dto.setId(rs.getString("id"));
					 dto.setPwd(rs.getString("pwd"));
					 list.add(dto);
				}
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(field_find.equals("2")) {
			try {
				sql = "select * from student1 where name like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+field_name+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 StudentDTO dto = new StudentDTO();
					 dto.setHakbun(rs.getInt("hakbun"));
					 dto.setName(rs.getString("name"));
					 dto.setId(rs.getString("id"));
					 dto.setPwd(rs.getString("pwd"));
					 list.add(dto);
				}
				rs.close(); pstmt.close(); con.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(field_find.equals("3")) {
			try {
				sql = "select * from student1 where name like ? or id like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+field_name+"%");
				pstmt.setString(2, "%"+field_name+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 StudentDTO dto = new StudentDTO();
					 dto.setHakbun(rs.getInt("hakbun"));
					 dto.setName(rs.getString("name"));
					 dto.setId(rs.getString("id"));
					 dto.setPwd(rs.getString("pwd"));
					 list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
		
}
