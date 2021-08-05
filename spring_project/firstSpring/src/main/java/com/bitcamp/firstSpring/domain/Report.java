package com.bitcamp.firstSpring.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
	
	private String sno;
	private String sname;
	private MultipartFile report;
	
	
	// 기본 생성자 생성
	public Report() {}
	
	
	public Report(String sno, String sname, MultipartFile report) {
		this.sno = sno;
		this.sname = sname;
		this.report = report;
	}


	
	// getter-setter
	public String getSno() {
		return sno;
	}


	public void setSno(String sno) {
		this.sno = sno;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public MultipartFile getReport() {
		return report;
	}


	public void setReport(MultipartFile report) {
		this.report = report;
	}

	
	
	

	
}
