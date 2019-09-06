package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 데이터 베이스와 연동하는 객체
// insert, update, delete, select 
public class BoardDAO {

	Connection con = null; // DB와 연결 하는 객체
	PreparedStatement pstmt = null; // sql문을 DB에 전송하는 객체
	ResultSet rs = null; // sql문의 결과 값을 가지고 있는 객체
	String sql = null;
	
	public BoardDAO() { // 기본 생성자
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
	
	// Board 테이블의 전체 레코드를 조회하는 메서드
	// board 테이블의 전체 목록을 검색 해서 Arraylist 객체에 저장 
	public ArrayList<BoardDTO> getBoardList() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			sql ="select * from board order by board_no desc";
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
			//open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	// board 테이블의 글번호에 해당하는 조회수 증가시키는 메서드
	public void boardHit(int board_no) {
		try {
			sql = "update board set board_hit = board_hit + 1 where board_no=?"; // 인자 값에(글번호)에 대한 조회수 = 조회수+1
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeQuery();
			//open 객체 닫기
			pstmt.close(); //con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글번호를 해당하는 글을 조회하는 메서드
	public BoardDTO boardcont(int board_no){
		BoardDTO dto = new BoardDTO();
		try {
			sql = "select * from board where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			while(rs.next()){ // 하나 밖에 없어서 if를 사용해도 됨
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));		
			}
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// board 테이블에 게시글을 추가하는 메서드
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		
		try {
			sql = "insert into board values(board_seq.nextval,?,?,?,?,default,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_writer());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			result = pstmt.executeUpdate();
			// open 객체 닫아주기
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// board 테이블의 게시글을 수정하는 메서드
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "select * from board where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (dto.getBoard_pwd().equals(rs.getString("board_pwd"))) {
					sql = "update board set board_title=?, board_cont=? where board_no=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getBoard_title());
					pstmt.setString(2, dto.getBoard_cont());
					pstmt.setInt(3, dto.getBoard_no());
					result = pstmt.executeUpdate();
				} else { // 비밀번호가 틀린경우
					result = -1;
				}
			} else { // 게시글 번호가 없는 경우
				result = -2;
			}
			// open 객체 닫기
			pstmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// board 테이블의 게시글을 삭제하는 메서드
	public int deleteBoard(String pwd, int board_no) {
		int result = 0;

		try {
			sql = "select * from board where board_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from board where board_no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, board_no);
					result = pstmt.executeUpdate();
				} else { // 게시글 번호가 없을 경우
					result = -1;
				}
			} else { // 비밀번호가 다를 경우
				result = -2;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}
}
