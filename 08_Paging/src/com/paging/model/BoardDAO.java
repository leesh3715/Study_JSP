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
	
	public int insertBoard(BoardDTO dto){
		int result = 0;
		int count = 0;
		try {
			sql = "select max(board_no) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1) + 1;
			} else {
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
	// board 테이블의 조회수를 증가 시키는 메서드
	public void boardHit(int board_no){
		
		try {
			sql = "update board set board_hit = board_hit+1 where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			
			pstmt.close(); //con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// board 테이블의 게시물 번호에 해당 하는 상세 내용 조회하는 메서드
	public BoardDTO boardCont(int board_no){
		BoardDTO dto = new BoardDTO();
		
		try {
			sql = "select * from board where board_no = ?";
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
				dto.setBoard_regdate(rs.getString("board_regdate"));
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
	// 게시글 삭제 메서드
	public int deleteBoard(int board_no){
		int result = 0;
		try {
			sql = "delete from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}
	// 게시글 수정 메서드
	public int editboard(int board_no, BoardDTO dto) {
		int result = 0;
		try {
			/*sql = "select * from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			rs = pstmt.executeQuery();*/
/*			if(rs.next()) {
				if(dto.getBoard_pwd().equals(rs.getString("board_pwd"))) {*/
				sql = "update board set board_title = ?, board_cont = ? where board_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getBoard_title());
				pstmt.setString(2, dto.getBoard_cont());
				pstmt.setInt(3, board_no);
				result = pstmt.executeUpdate();
				
			/*	} else {
					result = -1;
				}
			}*/
				pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	///////////////////////////	///////////////////////////	///////////////////////////	///////////////////////////	
	public ArrayList<BoardDTO> searchBoard(String find_field, String find_name, int page, int rowsize){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		System.out.println(page);
		System.out.println(rowsize);
		int startNo = ((page - 1) * rowsize) + 1;
		// 해당 페이지의 끝 글번호
		int endNo = (page * rowsize);
		
		if(find_field.equals("title")) {
			sql ="select * from (select p.*, row_number() over(order by board_no desc) rnum from board p where board_title like ?) where rnum >=? and rnum<=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
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
				// open 객체 닫기
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(find_field.equals("cont")){
			sql ="select * from (select p.*, row_number() over(order by board_no desc) rnum from board p where board_cont like ?) where rnum >=? and rnum<=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
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
				// open 객체 닫기
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if(find_field.equals("title+cont")){ 
			sql ="select * from (select p.*, row_number() over(order by board_no desc) rnum from board p where board_title like ?, board_cont like ?) where rnum >=? and rnum<=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				pstmt.setString(2, "%"+find_name+"%");
				pstmt.setInt(3, startNo);
				pstmt.setInt(4, endNo);
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
				// open 객체 닫기
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if(find_field.equals("writer")){
			sql ="select * from (select p.*, row_number() over(order by board_no desc) rnum from board p where board_writer like ?) where rnum >=? and rnum<=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
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
				// open 객체 닫기
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		return list;			
	}
	///////////////////////////	///////////////////////////	///////////////////////////	///////////////////////////	///////////////////////////
	public int getListCountSearch(String find_field, String find_name){
		int count = 0;
		System.out.println("렛리스트서치 실행");
		if(find_field.equals("title")){
		try {
			sql="select count(*) from board where board_title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+find_name+"%");
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1); // 쿼리를 실행한 값이 들어감
			}
			
			rs.close(); pstmt.close(); //con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		} else if(find_field.equals("cont")){
			try {
				sql="select count(*) from board where board_cont like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1); // 쿼리를 실행한 값이 들어감
				}
				rs.close(); pstmt.close(); //con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(find_field.equals("title+cont")){
			try {
				sql="select count(*) from board where board_title like ? or board_cont like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				pstmt.setString(2, "%"+find_name+"%");
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1); // 쿼리를 실행한 값이 들어감
				}
				rs.close(); pstmt.close(); //con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if(find_field.equals("writer")){
			try {
				sql="select count(*) from board where board_writer like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+find_name+"%");
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1); // 쿼리를 실행한 값이 들어감
				}
				rs.close(); pstmt.close(); //con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(count);
		return count;
	}
}
