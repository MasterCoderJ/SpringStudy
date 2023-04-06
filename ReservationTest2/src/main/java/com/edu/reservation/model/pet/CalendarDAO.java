package com.edu.reservation.model.pet;

import java.util.List;

import com.edu.reservation.domain.Calendar;

public interface CalendarDAO {
	
	public List selectAll();
	public void insert(Calendar calendar);

}
