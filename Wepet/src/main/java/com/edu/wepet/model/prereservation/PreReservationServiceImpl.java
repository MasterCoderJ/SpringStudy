package com.edu.wepet.model.prereservation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.wepet.domain.PreReservation;
import com.edu.wepet.exception.PreReservationException;

@Service
public class PreReservationServiceImpl implements PreReservationService{
	
	@Autowired
	private PreReservationDAO preReservationDAO;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Override
	public void insert(List preReservationList) throws PreReservationException{
		
		List<PreReservation> registedPreReservationList = preReservationDAO.selectAll();
		
		logger.info("서비스임플 속 registed" + registedPreReservationList);
		
		for (int i = 0; i < preReservationList.size(); i++) {
			PreReservation preReservation = (PreReservation) preReservationList.get(i);
			for (int a = 0; a < registedPreReservationList.size(); a++) {
				PreReservation registedPreReservation = registedPreReservationList.get(a);
				if (registedPreReservation.getYy().equals(preReservation.getYy())&&registedPreReservation.getMm().equals(preReservation.getMm())&&registedPreReservation.getDd().equals(preReservation.getDd())) {
					throw new PreReservationException("중복날짜");
				}
			}
			preReservationDAO.insert(preReservation);
		}

		
	}

	@Override
	public List selectAll() {
		return preReservationDAO.selectAll();
	}

	@Override
	public PreReservation select(int prereservation_idx) {
		return preReservationDAO.select(prereservation_idx);
	}

	@Override
	public void delete(PreReservation preReservation) throws PreReservationException{
		
		preReservationDAO.delete(preReservation);
		
	}

}
