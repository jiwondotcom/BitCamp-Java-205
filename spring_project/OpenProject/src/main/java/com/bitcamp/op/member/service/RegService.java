package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class RegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	// @Autowired
	// private MemberDao dao;
	
	// @Autowired
	// private JdbcTemplateMemberDao dao;
	
	@Autowired
	private mybatisMemberDao dao;
	
	
	public int regMember(
			
			MemberRegRequest regRequest,
			HttpServletRequest request
			
			) {
		 
		int resultCnt = 0;
		
		// Connection conn = null;
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
			String newFileName = regRequest.getUserID()+System.currentTimeMillis()+".jpg";
			// 예) jiwon23897235852938
			
			
			/*
			// 파일 확장자 구하기
			String fileName = regRequest.getPhoto().getOriginalFilename();
			// 업로드 파일의 contentType
			String contentType = regRequest.getPhoto().getContentType();
			
			// String[] java.lang.String.split(String regex) 
			// : 정규식의 패턴 문자열을 전달해야하기 때문에 \\. 으로 처리
			String[] nameTokens = fileName.split("\\.");
			
			// 토큰의 마지막 index의 문자열을 가져옴 : 배열의 개수-1
			String fileType = nameTokens[nameTokens.length-1];
			fileType = fileType.toLowerCase();
			
			// 이미지 파일 이외의 파일 업로드 금지
			// 파일 확장자 체크
			if(!(fileType.equals("jpg")||fileType.equals("png")||fileType.equals("gif")) ) {
				// 파일 contentType 체크
				if(!(contentType.equals("image/jpg")||contentType.equals("image/png")||contentType.equals("image/gif"))) {
					throw new Exception("허용하지 않는 파일 타입 : " + contentType);
				}
			}
			
			// 새로운 파일이름에 확장자 추가
			newFileName += "."+fileType;

			*/
			
			
			// 새로운 File 객체를 필요로 한다.
			newFile = new File(newDir, newFileName);
			
			// 파일 저장
			if(regRequest.getUserPhoto() != null && !regRequest.getUserPhoto().isEmpty()) {
				regRequest.getUserPhoto().transferTo(newFile);
			}
			
			
			// 2. dao 저장
			
			// conn = ConnectionProvider.getConnection();
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member = regRequest.toMember();
			member.setUserPhoto(newFileName);
			
			resultCnt = dao.insertMember(member);
			
			System.out.println("새롭게 등록된 index => " + member.getIndex());
			
		
			// index 값은 자식 테이블  insert시 외래키로 사용한다.
			
			// 자식테이블 insert 구문 실행
			
			
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			
			// DB예외 발생시, 저장된 파일을 삭제한다.
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			
			e.printStackTrace();
		}
		
		return resultCnt;
	}


}
