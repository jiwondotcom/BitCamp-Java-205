package com.bitcamp.op.member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class RegService {

	@Autowired
	MemberDao dao;

	
	int resultCnt = 0;
	
	Member member = new Member();
	
	Connection conn = null;
	File newFile = null;

	
	public int regMember(
			
			MemberRegRequest regRequest,
			HttpServletRequest request
			
			
			) throws FileUploadException {
		 
		
		try {
		// 1. mulitpart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			
			// 2. 파일을 저장할 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			
			// 3. 요청 처리를(form 안에 있는 input들을 분리) 위해서 ServletFileUpload 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// 4. 사용자 요청을 파싱(분리)
			// FileItem -> input 데이터를 저장하고 있는 객체
			List<FileItem> items = upload.parseRequest(request);
			
			Iterator<FileItem> itr = items.iterator();
			
			while(itr.hasNext()) {
				
				FileItem item = itr.next();
				// text, checkbox, hidden, password -> FormFeild 폼필드
				// file
				
				// file과 file 이외의 폼을 구분
				if(item.isFormField()) {
					
					// 회원 아이디, 회원 이름, 비밀번호
					String paramName = item.getFieldName();
					if(paramName.equals("userID")) {
						// String value = item.getString("UTF-8"); // 인코딩 처리
						member.setUserID(item.getString("UTF-8"));
					} else if (paramName.equals("userPW")) {
						member.setUserPW(item.getString("UTF-8"));
					} else if (paramName.equals("userName")) {
						member.setUserName(item.getString("UTF-8"));
					}
					
				} else {
					String uploadUri = "upload";
					String dir = request.getSession().getServletContext().getRealPath(uploadUri);
					
					File saveDir = new File(dir);
					
					if(!saveDir.exists()) {
						saveDir.mkdir();
					}
					
					String paramName = item.getFieldName();

					if(paramName.equals("userPhoto")) {
						
						// 파일 이름, 사이즈
						if(item.getName() != null && item.getSize() > 0) {
							// 저장
							newFile = new File(saveDir, item.getName());
							item.write(new File(saveDir, item.getName()));
							// DB에 저장할 파일의 이름
							member.setUserPhoto(item.getName());
							System.out.println("파일 저장 완료.");
						} 
							
					}
	 	 		}
				
			}
			
			
		} else {
			throw new Exception("multipart 타입이 아닙니다.");
		}
		
		
		////////////////////////////////////////////////////////////////////////////////////////
		// DB 인서트
		// Connection, MemberDao
		
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		resultCnt = dao.insertMember(conn, member);
		
		} catch(SQLException e) {
			e.printStackTrace();

			// DB 입력시 오류라면 파일을 삭제한다.
			if (newFile != null && newFile.exists()) {
				// 파일을 삭제
				newFile.delete();
				System.out.println("파일이 정상적으로 삭제되었습니다.");
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}


}
