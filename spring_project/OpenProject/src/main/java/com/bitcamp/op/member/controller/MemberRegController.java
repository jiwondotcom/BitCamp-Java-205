package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.service.RegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	
	@Autowired
	RegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String RegForm() {
		
		return "member/regForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			
			/*
			 * @RequestParam(value = "userID") String userID,
			 * 
			 * @RequestParam(value = "userPW") String userPW,
			 * 
			 * @RequestParam(value = "userName") String userName,
			 * 
			 * @RequestParam(value = "userPhoto", required = false) String userPhoto,
			 */
			
			MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			
			) throws FileUploadException {
		
		  int result = regService.regMember(regRequest, request);
		  model.addAttribute("result", result);
		
		// 회원가입을 위해 Service 객체를 이용한 핵심 처리
		return "member/memberReg";
	}
}
