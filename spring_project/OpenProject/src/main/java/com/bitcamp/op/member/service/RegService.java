package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class RegService {

	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
	private MemberDao dao;
	Member member;
	
	
	public int regMember(
			
			MemberRegRequest regRequest,
			HttpServletRequest request
			
			) {
		 
		int resultCnt = 0;
		
		Connection conn = null;
		File newFile = null;
	
		try {
			
			// 1. 파일 저장
			
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새로운 저장 폴더 : File
			File newDir = new File(path);
			
			// 폴더가 존재하지 않으면 폴더를 생성해주어야 한다.
			if(!newDir.exists()) {
				newDir.mkdir(); // 디렉토리 생성
				System.out.println("저장폴더 생성 완료!");
			}
			
			// 파일 저장시에 파일 이름이 같으면 덮어쓴다. -> 회원별 고유한 파일을 만들자(회원의 아이디 활용)
			String newFileName = regRequest.getUserID()+System.currentTimeMillis();
			// 예) jiwon23897235852938
			
			
			// 새로운 File 객체를 필요로 한다.
			newFile = new File(newDir, newFileName);
			
			// 파일 저장
			if(regRequest.getUserPhoto() != null && regRequest.getUserPhoto().isEmpty()) {
				regRequest.getUserPhoto().transferTo(newFile);
			}
			
			
			// 2. dao 저장
			
			conn = ConnectionProvider.getConnection();
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member = regRequest.toMember();
			member.setUserPhoto(newFileName);
			
			resultCnt = dao.insertMember(conn, member);
			
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			// DB예외 발생시, 저장된 파일을 삭제한다.
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		
		
		
		
		return resultCnt;
	}


}
