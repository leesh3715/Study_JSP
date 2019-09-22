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
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<BoardDTO> selectBoard(){
		System.out.println(3333);
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			sql = "select * from jsp_bbs order by board_group desc, board_step";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		
		try {
		sql="insert into jsp_bbs values(bbs_seq.nextval,?,?,?,?,default,sysdate,bbs_seq.currval,0,0)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getBoard_writer());
		pstmt.setString(2, dto.getBoard_title());
		pstmt.setString(3, dto.getBoard_cont());
		pstmt.setString(4, dto.getBoard_pwd());
		result = pstmt.executeUpdate();
		
		pstmt.close(); con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
	}
	// 조회수 증가 메서드
	public void boardHit(int board_no) {
		try {
			sql = "update jsp_bbs set board_hit = board_hit + 1 where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 상세 내역 조회 메서드
	public BoardDTO selectCont(int board_no) {
		BoardDTO dto = new BoardDTO();
		try {
			sql = "select * from jsp_bbs where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
