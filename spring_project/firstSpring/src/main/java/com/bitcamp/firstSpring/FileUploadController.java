package com.bitcamp.firstSpring;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	
		// 업로드 된 파일을 저장할 폴더 경로 설정
		// 상수 표현 -> 대문자
		final String UPLOAD_URI = "/uploadfile";

		
		@RequestMapping("/upload/uploadForm")
		public String getUplaodForm() {
			return "upload/uploadForm";
		}
		
		
		@RequestMapping(value = "/upload/upload1")
		public String upload(
				
				@RequestParam("sno") String sno, 				// 학번
				@RequestParam("sname") String sname,			// 학생 이름
				@RequestParam("report") MultipartFile report, 	// 리포트 파일
				Model model,
				HttpServletRequest request 						// 절대 경로를 불러온다.
				
				) throws IllegalStateException, IOException {
			
			System.out.println("학번 : " + sno);
			System.out.println("이름 : " + sname);
			System.out.println("파일 : " + report.getOriginalFilename());
			
			// getOriginalFileName() : 파일 이름을 가져온다.

			model.addAttribute("sno", sno);
			model.addAttribute("sname", sname);
			model.addAttribute("reportFile", report.getOriginalFilename());
			

			// 저장 경로 : 시스템 경로
			String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);

			
			// 새롭게 저장할 파일을 정의
			File newFile = new File(saveDir, report.getOriginalFilename());
			
			// 파일 저장
			report.transferTo(newFile);
			
			return "upload/upload";
		}
	
}
