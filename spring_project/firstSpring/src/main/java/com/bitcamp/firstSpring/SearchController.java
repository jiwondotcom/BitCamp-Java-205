package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
	 
	@RequestMapping("/search/search")
	public String search() {
		return "search/search";
	}

}
