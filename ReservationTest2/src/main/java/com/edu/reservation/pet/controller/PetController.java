package com.edu.reservation.pet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.reservation.model.pet.CalendarService;

@Controller
public class PetController {
	
	@Autowired
	private CalendarService calendarService;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/showdate")
	public ModelAndView getMain() {
		
		List calendarList= calendarService.selectAll();
//		logger.info("캘린더 속에는"+calendarList);
		
		ModelAndView mav= new ModelAndView("pet/calendar");
//		mav.addObject("calendarList", calendarList);
		
		return mav;
		
	}

}
