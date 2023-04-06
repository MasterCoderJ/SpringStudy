package com.edu.wepet.model.prereservation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.wepet.domain.PreReservation;
import com.edu.wepet.exception.PreReservationException;

@Repository
public class MyBatisPreReservationDAO implements PreReservationDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	@Override
	public void insert(PreReservation preReservation) throws PreReservationException{
		
		int result= sqlSessionTemplate.insert("PreReservation.insert", preReservation);
		
		if(result<1) {
			throw new PreReservationException("예약등록실패");
		}
		
	}

	@Override
	public List selectAll() {

		return sqlSessionTemplate.selectList("PreReservation.selectAll");
	}

	@Override
	public PreReservation select(int prereservation_idx) {

		return sqlSessionTemplate.selectOne("PreReservation.select", prereservation_idx);
	}

	@Override
	public void delete(PreReservation preReservation) throws PreReservationException{
		
		int result= sqlSessionTemplate.delete("PreReservation.delete",preReservation);
		
		if(result<1) {
			throw new PreReservationException("예약삭제 실패");
		}
	}

}
