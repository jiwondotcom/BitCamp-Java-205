package com.bitcamp.firstSpring.service;

import org.springframework.stereotype.Service;

import com.bitcamp.firstSpring.dao.Dao;

@Service
public class FileUploadService {

	Dao dao;
	
	public void fileUpload() {
		dao.insert();
	}
	
}
