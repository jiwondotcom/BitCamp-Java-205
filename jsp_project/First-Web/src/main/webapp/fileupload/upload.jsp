<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 사용자가 전송한 데이터, 파일 저장 -> view 파일의 경로 전달 -> 지정된 경로의 임지를 출력
	// 사용자 폼 데이터
	String title = null;
	// 서버에 저장된 파일의 이름
	String newFile = null;
	
	
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
				
				// 일반 input type 처리
				// 파라미터 이름, 해당 폼의 데이터(문자열)
				String paramName = item.getFieldName();
				if (paramName.equals("title")) {
					String paramValue = item.getString("UTF-8"); // 인코딩 처리
					title = paramValue;
					
					out.println("title : " + title + "<br>");
					
				} else if (paramName.equals("title2")) {
					
				}
				
				
			} else {
				// type = file 처리
						
				// 웹 경로
				String paramName = item.getFieldName();
				// 시스템 경로
				
				
				
				if(paramName.equals("photo")) {
					
					String userFileName = item.getName(); 			// 파일의 이름
					String contentType = item.getContentType();		// contentType 반환
					long fileSize = item.getSize();					// byte 사이즈
					
					out.println("fileName : " + userFileName + "<br>");
					out.println("contentType : " + contentType + "<br>");
					out.println("fileSize : " + fileSize + "<br>");
					
				} else if (paramName.equals("file")) {
					// ...
					
				}
 	 		}
			
			
			
		}
		
		
		
		
	}



%>
<%-- <jsp:forward page = "upload_view.jsp"/> --%>