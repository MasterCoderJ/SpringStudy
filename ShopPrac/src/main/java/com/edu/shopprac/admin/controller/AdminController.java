package com.edu.shopprac.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/main")
	public ModelAndView getMain() {
		logger.info("메인호출");
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("admin/index");
		
		return mav;
	} 

}
