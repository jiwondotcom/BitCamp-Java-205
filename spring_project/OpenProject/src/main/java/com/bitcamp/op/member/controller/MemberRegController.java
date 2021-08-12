package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.dao.mybatisMemberDao;
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
			
			) throws FileUploadException {
	
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
