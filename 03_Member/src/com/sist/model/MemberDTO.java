package com.sist.model;

// 기본적으로 DB테이블의 컬럼명과 유사하게 멤버 설정
public class MemberDTO {

	// 멤버변수
	private String id;
	private String pwd;
	private String name;
	private String reg_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}