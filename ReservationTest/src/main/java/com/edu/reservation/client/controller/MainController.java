package com.edu.reservation.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/main")
	public ModelAndView getMain() {
		
		ModelAndView mav= new ModelAndView("client/reservation");
		
		return mav;
		
	}

}
