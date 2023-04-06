package com.edu.wepet.model.holiday;

import java.util.List;

import com.edu.wepet.domain.Holiday;

public interface HolidayService {
	public void insert(List holidayList);
	public List selectAll();
	public Holiday select(int holiday_idx);
	public void delete(Holiday holiday);
}
