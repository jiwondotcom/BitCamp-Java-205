package service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MemeberRegService {
	
	// 싱글톤 처리
	private MemeberRegService() {}
	private static MemeberRegService service = new MemeberRegService();
	public static MemeberRegService getInstance() {
		return service;
	}
	
	
	public int regMember(HttpServletRequest request) {
		
		int resultCnt = 0;
		
		Member
		
		
		
		
		// 1. mulitpart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			
			// 2. 파일을 저장할 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			
			// 3. 요청 처리를(form 안에 있는 input들을 분리) 위해서 ServletFileUpload  생성
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
					
					// 회원 아이디, 회원 이름, 비밀번호, 
					
					
				} else {
					
					// 사진 데이터 처리
					
					
				
					if(paramName.equals("photo")) {
						
						String userFileName = item.getName(); 			// 파일의 이름
						String contentType = item.getContentType();		// contentType 반환
						long fileSize = item.getSize();					// byte 사이즈
						
						out.println("fileName : " + userFileName + "<br>");
						out.println("contentType : " + contentType + "<br>");
						out.println("fileSize : " + fileSize + "<br>");
						
						
						// 파일을 쓰기 위한 조건
						if (userFileName != null && fileSize > 0) {
							File savePath = new File(dir, userFileName);
							item.write(savePath);
							System.out.println("데이터 저장 완료.");
							newFile = userFileName;
							
						} 
						
						
					} else if (paramName.equals("file")) {
						// ...
						
					}
	 	 		}
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		return resultCnt;
	}

}
