package com.edu.reservationsystem.sitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SitterController {
	
	@GetMapping("/main")
	public ModelAndView getMain() {
		
		ModelAndView mav= new ModelAndView("user/calendar");
		
		return mav;
	}
	
	@GetMapping("/reservation")
	public ModelAndView getRes() {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("user/reservation");
		
		return mav;
	}

}
