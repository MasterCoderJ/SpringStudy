package com.edu.reservation.model.pet;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.reservation.domain.Calendar;
import com.edu.reservation.pet.exception.CalendarException;

@Repository
public class MybatisCalendarDAO implements CalendarDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		
		List list= sqlSessionTemplate.selectList("Calendar.selectAll");
		
		return list;
	}

	public void insert(Calendar calendar) throws CalendarException{
		
		int result= sqlSessionTemplate.insert("Calendar.insert", calendar);
		
		if(result<1) {
			throw new CalendarException("일정등록 실패");
		}
		
	}

}
