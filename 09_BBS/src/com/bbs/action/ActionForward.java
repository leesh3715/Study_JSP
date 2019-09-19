package com.bbs.action;

/*
 * ActionForward 클래스
 * 1. Action 인터페이스에서 리턴 타입으로 사용 될 클래스 
 * 2. isRedirect() 메서드
 * 	- jsp 페이지(false)
 *  - *.do 페에지(true)
 * 3. path() 메서드: 파일에 대한 경로를 지정하는 메서드
 * */

public class ActionForward {
	private boolean isRedirect;
	private String path;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
