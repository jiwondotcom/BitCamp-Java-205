package com.bitcamp.op;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

	@RequestMapping("/index")
	public void index() {
	}

	
	@RequestMapping("/")
	public String index1() {
		System.out.println("/ 진입");
		return "redirect:/index";
	}
	
	
}
