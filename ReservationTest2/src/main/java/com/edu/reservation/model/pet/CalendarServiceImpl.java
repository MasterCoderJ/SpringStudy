package com.edu.reservation.model.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.reservation.domain.Calendar;
import com.edu.reservation.pet.exception.CalendarException;

@Service
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired
	private CalendarDAO calendarDAO;

	@Override
	public List selectAll() {

		return calendarDAO.selectAll();
	}

	@Override
	public void insert(Calendar calendar) throws CalendarException{
		
		calendarDAO.insert(calendar);
	}

}
