package com.edu.wepet.model.holiday;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.wepet.domain.Holiday;
import com.edu.wepet.exception.HolidayException;

@Repository
public class MybatisHolidayDAO implements HolidayDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Holiday holiday) throws HolidayException{
		
		int result= sqlSessionTemplate.insert("Holiday.insert", holiday);
		
		if(result<1) {
			throw new HolidayException("휴무 등록 실패");
		}
	}

	@Override
	public List selectAll() {
		
		List list= sqlSessionTemplate.selectList("Holiday.selectAll");
		
		return list;
	}

	@Override
	public Holiday select(int holiday_idx) {
		
		return sqlSessionTemplate.selectOne("Holiday.select", holiday_idx);
	}

	@Override
	public void delete(Holiday holiday) throws HolidayException{
		
		int result= sqlSessionTemplate.delete("Holiday.delete",holiday);
		
		if(result<1) {
			throw new HolidayException("휴무 삭제 실패");
		}
	}

}
