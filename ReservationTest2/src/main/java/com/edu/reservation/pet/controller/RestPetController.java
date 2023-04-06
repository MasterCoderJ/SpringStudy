package com.edu.reservation.pet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.reservation.model.pet.CalendarService;
import com.edu.reservation.util.Message;

@RestController
@RequestMapping("/rest")
public class RestPetController {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CalendarService calendarService;
	
//	@GetMapping("/showdate")
	public ResponseEntity<Message> getInfo(){
		
		calendarService.selectAll();
		
		return null;
	}
}
