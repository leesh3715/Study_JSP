package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MangoDAO {

		Connection con = null; // DB와 연결 하는 객체
		PreparedStatement pstmt = null; // sql문을 DB에 전송하는 객체
		ResultSet rs = null; // sql문의 결과 값을 가지고 있는 객체
		String sql = null;
		
		public MangoDAO() { // 기본 생성자
			System.out.println("DB 객체 생성");
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

	public int userSignup(UserDTO dto) {
		int result = 0;
		System.out.println("회원가입 메서드실행");
		try {
			sql = "insert into mango_user values(?,?,?,?)";
			if (dto.getPwd().equals(dto.getPwd2())) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPwd());
				pstmt.setString(3, dto.getPwd2());
				pstmt.setString(4, dto.getName());
				result = pstmt.executeUpdate();
			} else {
				result = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<BoardDTO> selectBoard(){
		System.out.println("게시판 조회 메서드 실행");
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			sql ="select * from mango_board order by board_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 있으면 true 없으면 false
				// 테이블에서 하나의 레코드를 가져 와서 DTO 객체에 저장
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));
				list.add(dto); // DTO에 저장된 데이터를 ArrayList에 원소로 추가
			}
			// open 객체 닫기
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
