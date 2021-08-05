package com.bitcamp.firstSpring;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.firstSpring.domain.Report;

@Controller
public class FileUploadController {
	
	
		// 업로드 된 파일을 저장할 폴더 경로 설정
		// 상수 표현 -> 대문자
		final String UPLOAD_URI = "/uploadfile";

		
		@RequestMapping("/upload/uploadForm")
		public String getUplaodForm() {
			return "upload/uploadForm";
		}
		
		
		
		
		// @RequestParam 이용한 파일 업로드
		@RequestMapping(value = "/upload/upload1")
		public String upload(
				
				@RequestParam("sno") String sno, 				// 학번
				@RequestParam("sname") String sname,			// 학생 이름
				@RequestParam("report") MultipartFile report, 	// 리포트 파일
				Model model,
				HttpServletRequest request 						// 절대 경로를 불러온다.
				
				) throws IllegalStateException, IOException {
			
			System.out.println("학번1 : " + sno);
			System.out.println("이름1 : " + sname);
			System.out.println("파일1 : " + report.getOriginalFilename());
			
			// getOriginalFileName() : 파일 이름을 가져온다.

			model.addAttribute("sno", sno);
			model.addAttribute("sname", sname);
			model.addAttribute("reportFile", report.getOriginalFilename());
		
			saveFile(request, report);
			
			return "upload/upload";
		}
		
		
		
		
		/* MultipartHttpServletRequest 이용한 파일 업로드 */
		@RequestMapping("/upload/upload2")
		public String upload2(
				
				MultipartHttpServletRequest request,
				Model model
				
				) throws IllegalStateException, IOException {
			
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			MultipartFile report = request.getFile("report");
			
			System.out.println("학번2 : " + sno);
			System.out.println("이름2 : " + sname);
			System.out.println("파일2 : " + report.getOriginalFilename());
			
			// getOriginalFileName() : 파일 이름을 가져온다.

			model.addAttribute("sno", sno);
			model.addAttribute("sname", sname);
			model.addAttribute("reportFile", report.getOriginalFilename());
			
			saveFile(request, report);
			
			return "upload/upload";
		}
		
		
		
		
		/* Command 객체를 이용한 파일 업로드 */
		@RequestMapping("/upload/upload3")
		public String upload3(
				
				Report report,
				Model model,
				HttpServletRequest request
				
				) throws IllegalStateException, IOException {
			
			System.out.println("학번3 : " + report.getSno());
			System.out.println("이름3 : " + report.getSname());
			System.out.println("파일3 : " + report.getReport().getOriginalFilename());
			
			// getOriginalFileName() : 파일 이름을 가져온다.

			model.addAttribute("sno", report.getSno());
			model.addAttribute("sname", report.getSname());
			model.addAttribute("reportFile", report.getReport().getOriginalFilename());
			
			
			saveFile(request, report.getReport());
			
			
			return "upload/upload";
		}
		
		
		
		
		// 사용자 업로드한 파일을 저장하는 메소드 : saveFile
		private void saveFile(HttpServletRequest request, MultipartFile file) 
									throws IllegalStateException, IOException {
			
			// 저장 경로 : 시스템 경로
			String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);

			// 새롭게 저장할 파일을 정의
			File newFile = new File(saveDir, file.getOriginalFilename());
			
			// 파일 저장
			file.transferTo(newFile);
			
		}
		
		
	
}
