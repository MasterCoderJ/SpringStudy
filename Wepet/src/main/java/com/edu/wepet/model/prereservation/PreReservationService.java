package com.edu.wepet.model.prereservation;

import java.util.List;

import com.edu.wepet.domain.PreReservation;

public interface PreReservationService {
	
	public void insert(List preReservationList);
	public List selectAll();
	public PreReservation select(int prereservation_idx);
	public void delete(PreReservation preReservation);


}
