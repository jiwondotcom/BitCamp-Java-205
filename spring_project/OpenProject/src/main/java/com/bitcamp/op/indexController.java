package com.bitcamp.op;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping("/index")
	public void index() {
	}

	@RequestMapping("/")
	public String index1() {
		return "index";
	}
	
}
