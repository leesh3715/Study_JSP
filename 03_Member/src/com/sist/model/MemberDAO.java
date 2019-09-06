package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 실제로 DB와 연동하는 객체

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public MemberDAO() { // 기본 생성자
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
	} // 생성자 end

	// 전체 리스트를 조회하는 메서드 
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			sql = "select * from member1 order by reg_date asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getNString("pwd"));
				dto.setName(rs.getNString("name"));
				dto.setReg_date(rs.getString("reg_date"));
				list.add(dto);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// DB에 레코드 추가하는 메서드
	public int insert(MemberDTO dto) { // result 값을 반환하게 위해 int
		int result = 0; // 결과값
		try {
			sql = "insert into member1 values(?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			result = pstmt.executeUpdate(); // int형으로 반환 함 값이 들어 가면 1이 들어감
			// open 객체 닫기
			pstmt.close(); con.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}
	
	// DB에 레코드 수정하는 메서드
	public int update(MemberDTO dto) {
		int result = 0;
		try {
			sql = "select * from member1 where id=?"; // 내가 입력한 ID가 테이블에 있는지를 검사
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(dto.getPwd().equals(rs.getString("pwd"))){// 수정폼에서 비밀번호와 DB와 같은지(여기서는 이름만 수정하기 때문에 DB의 pwd값과 비교해 true 이면 update 문 실행
					sql = "update member1 set name=? where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getName());
					pstmt.setString(2, dto.getId());
					result = pstmt.executeUpdate();
				} else { // 폼과 DB의 비밀번호가 틀린 경우
					result = -1; // -1을 강제로 반환, DB와 폼의 비밀번호가 틀렸다는 의미
				} 
					
				}else { // 아이디가 DB에 없는 경우
					result = -2; // -2 강제로 반환, 아이디가 DB에 없다는 의미
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return result;
	}
	// DB에서 레코드를 삭제하는 메서드
	public int delete(String id, String pwd) {
		int result = 0;
		try {
			sql = "select * from member1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) {
					sql = "delete from member1 where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					result = pstmt.executeUpdate();
				} else { // 입력한 비밀번호가 같지 않을 경우
					result = -1;
				}
			} else { // 아이디가 없는 경우
				result = -2;
			}
			// open 객체 닫기
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
