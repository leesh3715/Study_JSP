package com.sist.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Board1_DAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;	
	
	public Board1_DAO() {
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
	}
	// board 테이블에서 전체 리스트를 가져오는 메서드
	public ArrayList<Board1_DTO> getList(){
		ArrayList<Board1_DTO> list = new ArrayList<Board1_DTO>();
	
		try {
			sql = "select * from board order by board_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board1_DTO dto = new Board1_DTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//게시물을 추가하는 메서드
	public int insertBoard(Board1_DTO dto){
		int result = 0;
		int count = 0;
		// 시퀀스를 사용하지 않고 글 번호 증가
		try {
			sql = "select max(board_no) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			} else{
				count = 1;
			}
			sql = "insert into board values(?,?,?,?,?,default,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			result = pstmt.executeUpdate();
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Board1_DTO boardcont(int board_no){
		Board1_DTO dto = new Board1_DTO();
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
}
