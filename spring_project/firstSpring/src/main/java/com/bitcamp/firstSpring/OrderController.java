package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/orderForm")
public class OrderController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";		// /WEB-INF/views/order/orderForm.jsp
	}
	
	
}
