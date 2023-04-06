package com.edu.wepet.model.prereservation;

import java.util.List;

import com.edu.wepet.domain.PreReservation;

public interface PreReservationDAO {
	
	public void insert(PreReservation preReservation);
	public List selectAll();
	public PreReservation select(int prereservation_idx);
	public void delete(PreReservation preReservation);

}
