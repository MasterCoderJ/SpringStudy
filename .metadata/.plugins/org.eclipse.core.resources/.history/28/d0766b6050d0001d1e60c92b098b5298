package com.edu.wepet.model.holiday;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.wepet.domain.Holiday;
import com.edu.wepet.exception.HolidayException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayDAO holidayDAO;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List selectAll() {

		return holidayDAO.selectAll();
	}

	@Override
	public Holiday select(int holiday_idx) {

		return holidayDAO.select(holiday_idx);
	}

	@Transactional
	public void insert(List holidayList) throws HolidayException {

		List<Holiday> registedHolidayList = holidayDAO.selectAll();
		
		logger.info("서비스임플 속 registed" + registedHolidayList);
		
		for (int i = 0; i < holidayList.size(); i++) {
			Holiday holiday = (Holiday) holidayList.get(i);
			for (int a = 0; a < registedHolidayList.size(); a++) {
				Holiday registedHoliday = registedHolidayList.get(a);
				if (registedHoliday.getYy().equals(holiday.getYy())&&registedHoliday.getMm().equals(holiday.getMm())&&registedHoliday.getDd().equals(holiday.getDd())) {
					log.info("이 안에 왜 못들어오니?");
					throw new HolidayException("중복날짜");
				}
			}
			holidayDAO.insert(holiday);
		}
	}

	@Override
	public void delete(Holiday holiday) throws HolidayException{
		
		holidayDAO.delete(holiday);
		
	}

}
