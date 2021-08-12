package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.service.RegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	
	@Autowired
	private RegService regService;

	
	@RequestMapping(method = RequestMethod.GET)  
	public String RegForm() {
		
		return "member/regForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			
			@ModelAttribute("regRequest") MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			
			) throws FileUploadException, SQLException {
	
			int result = regService.regMember(regRequest, request);
			model.addAttribute("result", result);
		
			String view = "member/memberReg";
			
			if(result == 1) {
				// 인덱스 페이지로 리다이렉트 처리
				System.out.println("회원 등록 완료");
				view = "redirect:/index";
			}
			
		
		return view;
	}
}
