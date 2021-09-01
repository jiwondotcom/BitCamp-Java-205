package com.bitcamp.app.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchType;
import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService ;
	
	@RequestMapping("/member/list")
	public String getList(
			
			SearchType searchType,
			Model model
			
			) {
		
		// System.out.println(searchType);
		
		List<Member> list = null;
		
		
		if(searchType.getKeyword() != null && searchType.getKeyword().trim().length() > 0) {
			list = listService.getMemberList(searchType);
		} else { 
			// 키워드가 없을시에는 리스트 전체가 검색되도록 설정한다.
			list = listService.getMemberList();
		}
		
		model.addAttribute("memberList", list);
		// model.addAttribute("memberList", listService.getMemberList(searchType));
		
		return "member/list";

	}
	
	
}