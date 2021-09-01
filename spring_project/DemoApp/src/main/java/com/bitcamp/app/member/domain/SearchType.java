package com.bitcamp.app.member.domain;

public class SearchType {

	private int p; // 페이징 처리시 페이지 번호
	private String searchType;
	private String keyword;
	
	
	// 생성자
	public SearchType(int p, String searchType, String keyword) {
		this.p = p;
		this.searchType = searchType;
		this.keyword = keyword;
	}
	
	
	// default 생성자
	// 아무것도 없을때 페이징 처리를 1로 한다.
	public SearchType() {
		this.p = 1;
	}

	
	// getter-setter
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	// 데이터 확인용 toString
	@Override
	public String toString() {
		return "SearchType [p=" + p + ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	
	
}
