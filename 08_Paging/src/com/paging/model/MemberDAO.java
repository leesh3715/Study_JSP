package com.paging.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;	
	
	public MemberDAO() {
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
	// 중복 아이디 체크 메서드
	public int checkMemberId(String id) {
		int result = 0; // 아이디 중복 여부 변수
		try {
			sql = "select member_id from jsp_member where member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;
			}
			//open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 우편번호를 검색하는 메서드
	public ArrayList searchZipcode(String dong){
		ArrayList zip = new ArrayList();
		
		try {
			sql="select * from zipcode where dong like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+dong+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong1 = rs.getString("dong");
				String bunji = rs.getString("bunji");
				// 번지를 뺀 주소 저장
				String addr1 = sido + gugun + dong1;
				// 번지를 포함한 주소 저장
				String addr2 = sido + gugun + dong1 + bunji;
				// list에 레코드 형태로 저장
				zip.add(zipcode +","+addr1+","+addr2);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zip;
	}
	// 회원 가입 메서드
	public int insertMember(MemberDTO dto) {
		int result = 0;
		try {
			sql = "insert into jsp_member(member_id, member_pwd, member_name, member_nickname, member_zip1, member_zip2, member_addr1, member_addr2, member_regdate, member_state)"
					+"values(?,?,?,?,?,?,?,?,sysdate,1)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_id());
			pstmt.setString(2, dto.getMember_pwd());
			pstmt.setString(3, dto.getMember_name());
			pstmt.setString(4, dto.getMember_nickname());
			pstmt.setString(5, dto.getMember_zip1());
			pstmt.setString(6, dto.getMember_zip2());
			pstmt.setString(7, dto.getMember_addr1());
			pstmt.setString(8, dto.getMember_addr2());
			result = pstmt.executeUpdate();
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// DB상에 아이디와 비밀번호가 있는지 확인하는 메서드
	public int userCheck(String id, String pwd){
		int result = 0;
		try {
			sql = "select * from jsp_member where member_id = ? and member_state = 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("member_pwd").equals(pwd)){
					// 회원인 경우
					result = 1;
				} else {
					// 비밀번호가 틀린 경우
					result = -1;
				}
			}else {
				// 회원이 아닌경우, 탈퇴한 경우
				result = -2;
			}
			rs.close(); pstmt.close(); //con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}
	public MemberDTO getMember(String id) {
		MemberDTO dto = new MemberDTO();
		try {
			sql = "select * from jsp_member where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_nickname(rs.getString("member_nickname"));
				dto.setMember_zip1(rs.getString("member_zip1"));
				dto.setMember_zip2(rs.getString("member_zip2"));
				dto.setMember_addr1(rs.getString("member_addr1"));
				dto.setMember_addr2(rs.getString("member_addr2"));
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
