package com.bbs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;	
	
	public BbsDAO() {
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
	
	// jsp_bbs테이블의 전체 게시글을 조회하는 메서드
	public ArrayList<BbsDTO> getBbsList(){
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			sql = "select * from jsp_bbs order by board_group desc, board_step";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BbsDTO dto = new BbsDTO();
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
	// jsp_bbs 테이블에서 게시글을 추가하는 메서드
	public int insertBoard(BbsDTO dto){
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
	// jsp_bbs 테이블에서 게시글 번호에 해당하는 게시글의 조휘수를 증가하는 메서드
	public void boardHit(int board_no){
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
	// jsp_bbs 테이블에서 글 번호로 상세 내용을 조회하는 메서드
	public BbsDTO getCont(int board_no){
		BbsDTO dto = new BbsDTO();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public int editBoard(BbsDTO dto, int board_no) {
		int result = 0;
		try {
			sql = "select * from jsp_bbs where board_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_pwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("board_pwd").equals(dto.getBoard_pwd())) {
					sql = "update jsp_bbs set board_writer = ?, board_title = ?, board_cont = ? where board_no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getBoard_writer());
					pstmt.setString(2, dto.getBoard_title());
					pstmt.setString(3, dto.getBoard_cont());
					pstmt.setInt(4, board_no);
					result = pstmt.executeUpdate();
				}
			} else {
				result = -1;
			}
			
			pstmt.close(); rs.close(); con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteBoard(int board_no, String pwd){
		int result = 0;
		try {
			sql = "select * from jsp_bbs where board_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from jsp_bbs where board_no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, board_no);
					result = pstmt.executeUpdate();
				}
			}
			pstmt.close(); con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//jsp_bbs 게시판의 글의 step을 하나 증가 시키는 메서드
	public void replyUpdate(int board_group, int board_step){
		try {
			sql = "update jsp_bbs set board_step = board_step + 1 where board_group = ? and board_step > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_group);
			pstmt.setInt(2, board_step);
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//jsp_bbs 게시판의 답변글을 추가하는 메서드
	public int replyBoard(BbsDTO dto){
		int result = 0;
		try {
			sql = "insert into jsp_bbs values(bbs_seq.nextval,?,?,?,?,default,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_writer());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			pstmt.setInt(5, dto.getBoard_group());
			pstmt.setInt(6, dto.getBoard_step() + 1); // 0은 자체 원래 글을 의미하고, 1을 추가함으로 답변글
			pstmt.setInt(7, dto.getBoard_indent() + 1);
			result = pstmt.executeUpdate();
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
