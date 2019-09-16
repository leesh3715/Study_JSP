package com.paging.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;	
	
	public BoardDAO() {
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
	
	public ArrayList<BoardDTO> selectList(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			sql = "select * from board order by board_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
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
	// Board 테이블의 전체 게시물의 수를 조회하는 메서드
	public int getListCount(){
		int count = 0;
		
		try {
			sql="select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1); // 쿼리를 실행한 값이 들어감
			}
			rs.close(); pstmt.close(); //con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// board 테이블에서 리스트를 가져오는 메서드
	public ArrayList<BoardDTO> getBoardList(int page, int rowsize) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		// 해당 페이지의 시작 글 번호
		int startNo = ((page - 1) * rowsize) + 1;
		// 해당 페이지의 끝 글번호
		int endNo = (page * rowsize);
		
		// row_number() over: 특정 컬럼을 기준으로 행 번호를 부여할 때 사용함
		try {
			sql = "select * from(select p.*, row_number() over(order by board_no desc) rnum from board p) where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
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
}

