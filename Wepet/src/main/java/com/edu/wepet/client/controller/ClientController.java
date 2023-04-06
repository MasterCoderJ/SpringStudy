package com.edu.wepet.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.wepet.model.holiday.HolidayService;

@Controller
public class ClientController {
	
	@Autowired
	private HolidayService holidayService;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/reservation")
	public ModelAndView getCalendar(HttpServletRequest request) {
		
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("wepet/client/client_reservation_form");
		
		return mav;
	}
	
	@GetMapping("/sitterlist")
	public ModelAndView getSitterList(HttpServletRequest request) {
		
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("wepet/client/petsitter_list");
		
		return mav;
	}
	
	@GetMapping("/fee")
	public ModelAndView getFee(HttpServletRequest request) {
		
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("wepet/client/fee");
		
		return mav;
	}



}
